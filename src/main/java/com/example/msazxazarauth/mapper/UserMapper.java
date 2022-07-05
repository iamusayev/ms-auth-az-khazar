package com.example.msazxazarauth.mapper;


import com.example.msazxazarauth.dao.entity.UserEntity;
import com.example.msazxazarauth.service.CreateUserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserEntity mapCreateDtoToEntity(CreateUserDto userDto) {
        return UserEntity.builder()
                .username(userDto.getName())
                .password(userDto.getPassword())
                .build();
    }

    public static UserResponseDto mapEntityToResponseDto(UserEntity userEntity) {
        return UserResponseDto.builder()
                .name(userEntity.getUsername())
                .build();
    }

    public static List<UserResponseDto> mapEntitiesToListResponseDto(List<UserEntity> userEntities) {
        return userEntities.stream()
                .map(UserMapper::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }

}
