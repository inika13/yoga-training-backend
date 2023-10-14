package com.example.demo.repository;

import com.example.demo.entity.StartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartRepository extends JpaRepository<StartEntity, Long> {
    
}
