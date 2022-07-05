package com.example.msazxazarauth.mapper;


import com.example.msazxazarauth.dao.entity.RoleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {


    public static RoleEntity mapCreateDtoToEntity(CreateRoleDto roleDto) {
        return RoleEntity.builder()
                .description(roleDto.getDescription())
                .distinguishedName(roleDto.getDistinguishedName())
                .name(roleDto.getName())
                .isStatic(roleDto.getIsStatic())
                .build();
    }

    public static RoleResponseDto mapEntityToResponseDto(RoleEntity roleEntity) {
        return RoleResponseDto.builder()
                .description(roleEntity.getDescription())
                .isStatic(roleEntity.getIsStatic())
                .name(roleEntity.getName())
                .build();
    }

    public static List<RoleResponseDto> mapEntitiesToListResponseDtos(List<RoleEntity> roleEntities) {
        return roleEntities.stream()
                .map(RoleMapper::mapEntityToResponseDto)
                .collect(Collectors.toList());
    }


}
