package com.example.msazxazarauth.model.dto;

import lombok.Value;

@Value
public class CreateRoleDto {

    String name;
    String distinguishedName;
    String description;
    String isStatic;

}
