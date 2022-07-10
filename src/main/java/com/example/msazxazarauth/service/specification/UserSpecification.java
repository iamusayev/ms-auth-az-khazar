package com.example.msazxazarauth.service.specification;


import com.example.msazxazarauth.model.criteria.UserCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class UserSpecification implements Specification {



    private UserCriteria userCriteria;

    private static final String USERNAME = "username";

    public UserSpecification(UserCriteria userCriteria) {
        this.userCriteria = userCriteria;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (userCriteria != null) {
            if (userCriteria.getName() != null) {
                predicates.add(criteriaBuilder.like(root.get(USERNAME),
                        "%"+userCriteria.getName()+"%"));
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
