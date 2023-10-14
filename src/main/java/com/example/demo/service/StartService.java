package com.example.demo.service;

import com.example.demo.entity.StartEntity;

import java.util.List;

public interface StartService {
    StartEntity createStartEntity(StartEntity startEntity);
    List<StartEntity> getAllStartEntities();
    StartEntity getStartEntityById(Long id);
    StartEntity updateStartEntity(Long id, StartEntity updatedStartEntity);
    void deleteStartEntity(Long id);
}
