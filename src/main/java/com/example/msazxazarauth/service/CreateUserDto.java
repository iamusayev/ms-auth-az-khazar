package com.example.msazxazarauth.service;

import com.example.msazxazarauth.mapper.CreateRoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto {


    private String username;

    @NotNull
    @NotEmpty
    private String password;

    @NotEmpty
    @NotNull
    private List<CreateRoleDto> roles;

}
