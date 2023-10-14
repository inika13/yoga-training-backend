package com.example.demo.service;

import com.example.demo.entity.BillEntity;
import com.example.demo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillInt implements BillService {

    private final BillRepository billRepository;

    @Autowired
    public BillInt(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public BillEntity createBilling(BillEntity billEntity) {
        return billRepository.save(billEntity);
    }

    @Override
    public BillEntity getBillingById(Long id) {
        Optional<BillEntity> optionalBill = billRepository.findById(id);
        return optionalBill.orElse(null);
    }

    @Override
    public BillEntity updateBilling(Long id, BillEntity billEntity) {
        if (billRepository.existsById(id)) {
            billEntity.setId(id);
            return billRepository.save(billEntity);
        }
        return null;
    }

    @Override
    public void deleteBilling(Long id) {
        if (billRepository.existsById(id)) {
            billRepository.deleteById(id);
        }
    }

    @Override
    public List<BillEntity> getAllBilling() {
        return billRepository.findAll();
    }
}
