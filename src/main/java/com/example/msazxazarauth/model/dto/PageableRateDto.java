package com.example.msazxazarauth.model.dto;

import com.example.msazxazarauth.mapper.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PageableRateDto <T>{



    private List<RoleResponseDto> rates;
    private int lastPageNumber;
    private boolean hasNextPage;

}
