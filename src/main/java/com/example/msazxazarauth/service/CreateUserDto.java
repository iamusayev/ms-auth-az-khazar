package com.example.msazxazarauth.service;

import com.example.msazxazarauth.dao.entity.RoleEntity;
import lombok.Value;

import java.util.List;

@Value
public class CreateUserDto {

    String name;
    String password;
    List<RoleEntity> roles;

}
