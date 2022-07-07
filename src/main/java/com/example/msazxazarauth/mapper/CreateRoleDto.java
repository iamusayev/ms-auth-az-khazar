package com.example.msazxazarauth.mapper;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value
public class CreateRoleDto {

    @NotNull
    @NotEmpty
    String name;

    @NotEmpty
    @NotNull
    String distinguishedName;

    @NotEmpty
    @NotNull
    String description;

    @NotEmpty
    @NotNull
    @Size(max = 16, min = 2)
    String isStatic;

}
