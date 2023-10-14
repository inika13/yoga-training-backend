package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.JoinEntity;
import com.example.demo.service.JoinService;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/join")
public class JoinController {

    @Autowired
    private JoinService joinService;

    @PostMapping("/post")
    public JoinEntity createJoin(@RequestBody JoinEntity joinEntity) {
        return joinService.createJoin(joinEntity);
    }

    @GetMapping("/")
    public List<JoinEntity> getAllJoins() {
        return joinService.getAllJoins();
    }

    @GetMapping("/{id}")
    public JoinEntity getJoinById(@PathVariable Long id) {
        return joinService.getJoinById(id);
    }

    @PutMapping("/{id}")
    public JoinEntity updateJoin(@PathVariable Long id, @RequestBody JoinEntity updatedJoinEntity) {
        return joinService.updateJoin(id, updatedJoinEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteJoin(@PathVariable Long id) {
        joinService.deleteJoin(id);
    }
}
