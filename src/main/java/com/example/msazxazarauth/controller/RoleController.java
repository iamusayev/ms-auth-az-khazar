package com.example.msazxazarauth.controller;

import com.example.msazxazarauth.mapper.CreateRoleDto;
import com.example.msazxazarauth.model.criteria.PageCriteria;
import com.example.msazxazarauth.model.criteria.RoleCriteria;
import com.example.msazxazarauth.model.dto.PageableRateDto;
import com.example.msazxazarauth.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/roles")
@RequiredArgsConstructor
public class RoleController {


    private final RoleService roleService;

    @PutMapping("/{id}")
    public void updateRole(@PathVariable Long id, @RequestBody @Valid CreateRoleDto roleDto) {
        roleService.updateRole(id, roleDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public PageableRateDto get(RoleCriteria roleCriteria, PageCriteria pageCriteria) {
        return roleService.getRoles(roleCriteria, pageCriteria);
    }
}
