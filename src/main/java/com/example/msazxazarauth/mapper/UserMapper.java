package com.example.msazxazarauth.mapper;


import com.example.msazxazarauth.dao.entity.UserEntity;
import com.example.msazxazarauth.service.CreateUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {

    private static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity mapCreateDtoToEntity(CreateUserDto userDto);

    public abstract UserResponseDto mapEntityToResponseDto(UserEntity userEntity);

    public abstract List<UserResponseDto> mapEntitiesToListResponseDto(List<UserEntity> userEntities);


    public static UserMapper getInstance() {
        return INSTANCE;
    }
}


