package com.example.msazxazarauth.service;

import com.example.msazxazarauth.controller.handler.NotFoundException;
import com.example.msazxazarauth.dao.entity.RoleEntity;
import com.example.msazxazarauth.dao.repository.RoleRepository;
import com.example.msazxazarauth.mapper.CreateRoleDto;
import com.example.msazxazarauth.mapper.RoleMapper;
import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.RoleCriteria;
import com.example.msazxazarauth.model.dto.PageableRateDto;
import com.example.msazxazarauth.service.specification.RoleSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.msazxazarauth.model.constants.ExceptionConstants.NOT_FOUND_EXCEPTION_CODE;
import static com.example.msazxazarauth.model.constants.ExceptionConstants.NOT_FOUND_EXCEPTION_MESSAGE;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {


    private final RoleRepository roleRepository;

    public void saveRole(CreateRoleDto roleDto) {
        log.info("ActionLog.saveRole.start");

        var roleEntity = RoleMapper.getInstance().mapCreateDtoToEntity(roleDto);
        roleRepository.save(roleEntity);

        log.info("ActionLog.saveRole.end");
    }

    public void updateRole(Long id, CreateRoleDto roleDto) {
        log.info("ActionLog.updateRole.start id: {}", id);

        var roleEntity = fetchRoleIfExist(id);
        roleEntity.setName(roleDto.getName());
        roleEntity.setDescription(roleDto.getDescription());
        roleEntity.setDistinguishedName(roleDto.getDistinguishedName());
        roleEntity.setIsStatic(roleDto.getIsStatic());
        roleRepository.save(roleEntity);

        log.info("ActionLog.updateRole.end id: {}", id);
    }

    public void deleteRole(Long id) {
        log.info("ActionLog.deleteRole.start id: {}", id);

        roleRepository.deleteById(id);

        log.info("ActionLog.deleteRole.end id: {}", id);
    }


    public PageableRateDto getRoles(RoleCriteria roleSpecification, PageCriteria pageCriteria) {

        int pageNumber = pageCriteria.getPage();
        int count = pageCriteria.getCount();

        var pageRequest = PageRequest.of(pageNumber, count);
        var specification = new RoleSpecification(roleSpecification);

        Page<RoleEntity> rolePage = roleRepository.findAll(specification, pageRequest);
        List<RoleEntity> roles = rolePage.getContent();

        int ratePageCounts = rolePage.getTotalPages();


        if (ratePageCounts != 0) {
            ratePageCounts -= 1;
        }


        return PageableRateDto.builder()
                .rates(RoleMapper.getInstance().mapEntitiesToListResponseDtos(roles))
                .lastPageNumber(ratePageCounts)
                .hasNextPage(rolePage.hasNext())
                .build();
    }

    private RoleEntity fetchRoleIfExist(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> {
            log.error("ActionLog.fetchRoleIfExist.error id: {}", id);
            throw new NotFoundException(String.format(NOT_FOUND_EXCEPTION_MESSAGE, "Role", id), NOT_FOUND_EXCEPTION_CODE);
        });
    }

}
