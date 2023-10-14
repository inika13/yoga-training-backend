package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.JoinEntity;

public interface JoinInt {

    JoinEntity createJoin(JoinEntity joinEntity);

    List<JoinEntity> getAllJoins();

    JoinEntity getJoinById(Long id);

    JoinEntity updateJoin(Long id, JoinEntity updatedJoinEntity);

    void deleteJoin(Long id);
}
