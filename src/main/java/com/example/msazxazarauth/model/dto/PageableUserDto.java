package com.example.msazxazarauth.model.dto;

import com.example.msazxazarauth.mapper.UserResponseDto;
import lombok.*;

import java.util.List;

@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageableUserDto {

    private List<UserResponseDto> users;
    private int lastPageNumber;
    private boolean hasNextPage;

}
