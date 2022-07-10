package com.example.msazxazarauth.dao.repository;

import com.example.msazxazarauth.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {


    Optional<UserEntity> findByUsername(String username);



}
