package com.example.msazxazarauth.mapper;


import com.example.msazxazarauth.dao.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class RoleMapper {


    private static final RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    public abstract RoleEntity mapCreateDtoToEntity(CreateRoleDto roleDto);

    public abstract RoleResponseDto mapEntityToResponseDto(RoleEntity roleEntity);


    public abstract List<RoleResponseDto> mapEntitiesToListResponseDtos(List<RoleEntity> roleEntities);


    public static RoleMapper getInstance() {
        return INSTANCE;
    }
}
