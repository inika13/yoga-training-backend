package com.example.demo.service;

import com.example.demo.entity.BillEntity;

import java.util.List;

public interface BillService {

    BillEntity createBilling(BillEntity billEntity);

    BillEntity getBillingById(Long id);

    BillEntity updateBilling(Long id, BillEntity billEntity);

    void deleteBilling(Long id);

    List<BillEntity> getAllBilling();
}
