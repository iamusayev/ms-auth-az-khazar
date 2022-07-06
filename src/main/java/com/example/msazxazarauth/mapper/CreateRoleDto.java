package com.example.msazxazarauth.mapper;

import lombok.Value;

@Value
public class CreateRoleDto {

    String name;
    String distinguishedName;
    String description;
    String isStatic;

}
