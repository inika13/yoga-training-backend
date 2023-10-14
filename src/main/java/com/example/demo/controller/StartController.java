package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.StartEntity;
import com.example.demo.repository.StartRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth/api/start")
public class StartController {

    private final StartRepository startEntityRepository;

    @Autowired
    public StartController(StartRepository startEntityRepository) {
        this.startEntityRepository = startEntityRepository;
    }

    @PostMapping
    public StartEntity createStartEntity(@RequestBody StartEntity startEntity) {
        return startEntityRepository.save(startEntity);
    }

    @GetMapping
    public List<StartEntity> getAllStartEntities() {
        return startEntityRepository.findAll();
    }

    
    @GetMapping("/{id}")
    public StartEntity getStartEntityById(@PathVariable Long id) {
        return startEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StartEntity not found with id: " + id));
    }

    
    @PutMapping("/{id}")
    public StartEntity updateStartEntity(@PathVariable Long id, @RequestBody StartEntity updatedStartEntity) {
        StartEntity existingStartEntity = startEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("StartEntity not found with id: " + id));

        existingStartEntity.setGender(updatedStartEntity.getGender());
        existingStartEntity.setAge(updatedStartEntity.getAge());
        existingStartEntity.setHeight(updatedStartEntity.getHeight());
        existingStartEntity.setWeight(updatedStartEntity.getWeight());

        return startEntityRepository.save(existingStartEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteStartEntity(@PathVariable Long id) {
        startEntityRepository.deleteById(id);
        return "StartEntity with ID " + id + " has been deleted";
    }
}
