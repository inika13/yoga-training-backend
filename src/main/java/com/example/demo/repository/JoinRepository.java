package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.JoinEntity;

@Repository
public interface JoinRepository extends JpaRepository<JoinEntity, Long> {
}

