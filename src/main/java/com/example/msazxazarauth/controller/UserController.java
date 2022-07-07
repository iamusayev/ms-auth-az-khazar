package com.example.msazxazarauth.controller;

import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.UserCriteria;
import com.example.msazxazarauth.service.CreateUserDto;
import com.example.msazxazarauth.service.PageableUserDto;
import com.example.msazxazarauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid CreateUserDto dto) {
        userService.saveUser(dto);
    }

















    @PatchMapping("/{id}")
    public void updateUserPassword(@PathVariable Long id, @RequestBody String password) {
        userService.updateUserPassword(id, password);
    }


    @GetMapping
    public PageableUserDto getUsers(UserCriteria userCriteria, PageCriteria pageCriteria) {
        return userService.getUsers(userCriteria, pageCriteria);
    }

}
