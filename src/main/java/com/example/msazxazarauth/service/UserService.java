package com.example.msazxazarauth.service;

import com.example.msazxazarauth.controller.handler.NotFoundException;
import com.example.msazxazarauth.dao.entity.UserEntity;
import com.example.msazxazarauth.dao.repository.UserRepository;
import com.example.msazxazarauth.exception.UserAlreadyExistException;
import com.example.msazxazarauth.mapper.UserMapper;
import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.UserCriteria;
import com.example.msazxazarauth.model.dto.CreateUserDto;
import com.example.msazxazarauth.model.dto.PageableUserDto;
import com.example.msazxazarauth.service.specification.UserSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.example.msazxazarauth.model.constants.ExceptionConstants.*;
import static com.example.msazxazarauth.model.constants.ExceptionConstants.NOT_FOUND_EXCEPTION_CODE;
import static com.example.msazxazarauth.model.constants.ExceptionConstants.NOT_FOUND_EXCEPTION_MESSAGE;


@Service
@RequiredArgsConstructor
@Slf4j
public class UserService  implements UserDetailsService{


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateUserPassword(Long id, String password) {
        log.info("ActionLog.updateUserPassword.start id :{}", id);

        var userEntity = fetchUserIfExist(id);
        var encryptedPassword = passwordEncoder.encode(password);
        userEntity.setPassword(encryptedPassword);
        userRepository.save(userEntity);

        log.info("ActionLog.updateUserPassword.end id :{}", id);
    }



            private UserEntity fetchUserIfExist(Long id) {
                return userRepository.findById(id).orElseThrow(() -> {
                    log.error("ActionLog.error.fetchUserIfExist id: {}", id);
                    throw new NotFoundException(String.format(NOT_FOUND_EXCEPTION_MESSAGE, "User", id), NOT_FOUND_EXCEPTION_CODE);
                });
            }















    public void saveUser(CreateUserDto userDto) {
        log.info("ActionLog.saveUser.start");

        Optional<UserEntity> maybeUser = userRepository.findByUsername(userDto.getUsername());
        if (maybeUser.isPresent()) {
            throw new UserAlreadyExistException(USER_ALREADY_EXIST_MESSAGE, USER_ALREADY_EXIST_CODE);
        }

        var userEntity = UserMapper.getInstance().mapCreateDtoToEntity(userDto);
        var encryptedPassword = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword((encryptedPassword));
        userRepository.save(userEntity);

        log.info("ActionLog.saveUser.end");
    }










    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("ActionLog.loadUserByUsername.start: username {} ", username);
        var user = userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
        if (user == null) {
            log.error("User not found ind the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            log.info("ActionLog.loadUserByUsername.success: username {} ", username);
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        }
    }





    public PageableUserDto getUsers(UserCriteria userCriteria, PageCriteria pageCriteria) {

        int pageNumber = pageCriteria.getPage();
        int count = pageCriteria.getCount();

        var pageRequest = PageRequest.of(pageNumber, count);
        var specification = new UserSpecification(userCriteria);

        Page<UserEntity> userPage = userRepository.findAll(specification, pageRequest);
        List<UserEntity> roles = userPage.getContent();

        int userPageCounts = userPage.getTotalPages();

        if (userPageCounts != 0) {
            userPageCounts -= 1;
        }

        return PageableUserDto.builder()
                .users(UserMapper.getInstance().mapEntitiesToListResponseDtos(roles))
                .lastPageNumber(userPageCounts)
                .hasNextPage(userPage.hasNext())
                .build();
    }





}
