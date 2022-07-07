package com.example.msazxazarauth.service;

import com.example.msazxazarauth.mapper.CreateRoleDto;
import lombok.Value;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Value
public class CreateUserDto {


    @NotNull
    @Size(min = 6, max = 16)
    String username;

    @NotNull
    @Size(min = 6, max = 16)
    String password;

    @NotEmpty
    @NotNull
    List<CreateRoleDto> roles;

}
