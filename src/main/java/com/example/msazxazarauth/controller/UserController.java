package com.example.msazxazarauth.controller;

import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.UserCriteria;
import com.example.msazxazarauth.service.PageableUserDto;
import com.example.msazxazarauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public PageableUserDto getUsers(UserCriteria userCriteria, PageCriteria pageCriteria) {
        return userService.getUsers(userCriteria, pageCriteria);
    }

}
