package com.example.demo.repository;

import com.example.demo.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<BillEntity, Long> {
    // You can add custom query methods here if needed
}
