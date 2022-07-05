package com.example.msazxazarauth.controller;

import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.RoleCriteria;
import com.example.msazxazarauth.service.PageableRateDto;
import com.example.msazxazarauth.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PageableRateDto get(RoleCriteria roleCriteria, PageCriteria pageCriteria) {
        return roleService.getRoles(roleCriteria, pageCriteria);
    }

}
