package com.example.msazxazarauth.service;

import com.example.msazxazarauth.mapper.CreateRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class CreateUserDto {


    @NotNull
    @Size(min = 6, max = 16)
    private String username;

    @NotNull
    @Size(min = 6, max = 16)
    private String password;

    @NotEmpty
    @NotNull
    private List<CreateRoleDto> roles;

}
