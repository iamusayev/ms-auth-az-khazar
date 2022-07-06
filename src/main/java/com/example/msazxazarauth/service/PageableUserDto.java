package com.example.msazxazarauth.service;

import com.example.msazxazarauth.mapper.UserResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageableUserDto {

    private List<UserResponseDto> users;
    private int lastPageNumber;
    private boolean hasNextPage;

}
