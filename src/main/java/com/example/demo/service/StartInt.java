package com.example.demo.service;

import com.example.demo.entity.StartEntity;
import com.example.demo.repository.StartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartInt implements StartService {

    private final StartRepository startRepository;

    @Autowired
    public StartInt(StartRepository startEntityRepository) {
        this.startRepository = startEntityRepository;
    }

    @Override
    public StartEntity createStartEntity(StartEntity startEntity) {
        return startRepository.save(startEntity);
    }

    @Override
    public List<StartEntity> getAllStartEntities() {
        return startRepository.findAll();
    }

    @Override
    public StartEntity getStartEntityById(Long id) {
        return startRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StartEntity not found with id: " + id));
    }

    @Override
    public StartEntity updateStartEntity(Long id, StartEntity updatedStartEntity) {
        StartEntity existingStartEntity = startRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StartEntity not found with id: " + id));

        existingStartEntity.setGender(updatedStartEntity.getGender());
        existingStartEntity.setAge(updatedStartEntity.getAge());
        existingStartEntity.setHeight(updatedStartEntity.getHeight());
        existingStartEntity.setWeight(updatedStartEntity.getWeight());

        return startRepository.save(existingStartEntity);
    }

    @Override
    public void deleteStartEntity(Long id) {
        startRepository.deleteById(id);
    }
}
