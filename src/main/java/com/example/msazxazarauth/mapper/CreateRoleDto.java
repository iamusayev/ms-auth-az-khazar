package com.example.msazxazarauth.mapper;

import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CreateRoleDto {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 10)
    String name;

    @NotEmpty
    @NotNull
    String distinguishedName;

    @NotEmpty
    @NotNull
    String description;

    @NotEmpty
    @NotNull
    @Size(min = 2, max = 16)
    String isStatic;

}
