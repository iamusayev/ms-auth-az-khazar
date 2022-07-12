package com.example.msazxazarauth.mapper;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RoleResponseDto {


    private String name;
    private String isStatic;
    private String description;

}
