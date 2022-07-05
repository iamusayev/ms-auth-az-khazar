package com.example.msazxazarauth.service.specification;


import com.example.msazxazarauth.dao.entity.RoleEntity;
import com.example.msazxazarauth.model.criteria.RoleCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class RoleSpecification implements Specification<RoleEntity> {


    private static final String NAME = "name";
    private static final String DESCRIPTION = "description";

    private RoleCriteria roleCriteria;

    public RoleSpecification(RoleCriteria roleCriteria) {
        this.roleCriteria = roleCriteria;
    }

    @Override
    public Predicate toPredicate(Root<RoleEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if (roleCriteria != null) {
            if (roleCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get(NAME),
                        "%" + roleCriteria.getName() + "%"));
            }
            if (roleCriteria.getDescription() != null) {
                predicates.add(criteriaBuilder.equal(root.get(DESCRIPTION),
                        roleCriteria.getDescription()));
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
