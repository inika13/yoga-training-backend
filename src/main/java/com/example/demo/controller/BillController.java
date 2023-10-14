package com.example.demo.controller;


import com.example.demo.entity.BillEntity;
import com.example.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/auth/api/billing") 
public class BillController {

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    
    @PostMapping
    public BillEntity createBilling(@RequestBody BillEntity billEntity) {
        return billService.createBilling(billEntity);
    }

    
    @GetMapping("/{id}")
    public BillEntity getBillingById(@PathVariable Long id) {
        return billService.getBillingById(id);
    }

    
    @PutMapping("/{id}")
    public BillEntity updateBilling(@PathVariable Long id, @RequestBody BillEntity billEntity) {
        return billService.updateBilling(id, billEntity);
    }

  
    @DeleteMapping("/{id}")
    public void deleteBilling(@PathVariable Long id) {
        billService.deleteBilling(id);
    }

 
    @GetMapping
    public List<BillEntity> getAllBilling() {
        return billService.getAllBilling();
    }
}
