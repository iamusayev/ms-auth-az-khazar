package com.example.msazxazarauth.controller;

import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.UserCriteria;
import com.example.msazxazarauth.model.dto.CreateUserDto;
import com.example.msazxazarauth.model.dto.PageableUserDto;
import com.example.msazxazarauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void save(@RequestBody @Valid CreateUserDto dto) {
        userService.saveUser(dto);
    }













    @PatchMapping("/{id}")
    public void updateUserPassword(@PathVariable Long id, @RequestParam String password) {
        userService.updateUserPassword(id, password);
    }











    @GetMapping
    public PageableUserDto getUsers(UserCriteria userCriteria, PageCriteria pageCriteria) {
        return userService.getUsers(userCriteria, pageCriteria);
    }

}
