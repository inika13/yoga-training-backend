package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.JoinEntity;
import com.example.demo.repository.JoinRepository;

import java.util.List;

@Service
public class JoinService implements JoinInt {

    @Autowired
    private JoinRepository joinRepository;

    @Override
    public JoinEntity createJoin(JoinEntity joinEntity) {
        return joinRepository.save(joinEntity);
    }

    @Override
    public List<JoinEntity> getAllJoins() {
        return joinRepository.findAll();
    }

    @Override
    public JoinEntity getJoinById(Long id) {
        return joinRepository.findById(id).orElse(null);
    }

    @Override
    public JoinEntity updateJoin(Long id, JoinEntity updatedJoinEntity) {
        JoinEntity existingJoinEntity = joinRepository.findById(id).orElse(null);
        if (existingJoinEntity != null) {
            // Update existingJoinEntity with fields from updatedJoinEntity
            // Set the fields and save
            return joinRepository.save(existingJoinEntity);
        }
        return null;
    }

    @Override
    public void deleteJoin(Long id) {
        joinRepository.deleteById(id);
    }
}

