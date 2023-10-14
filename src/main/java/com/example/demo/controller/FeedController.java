package com.example.demo.controller;

import com.example.demo.entity.FeedEntity;
import com.example.demo.repository.FeedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@RestController
@RequestMapping("auth/api/feedback")
public class FeedController {

    @Autowired
    private FeedRepository feedRepository;

    @GetMapping
    public List<FeedEntity> getAllFeedback() {
        return feedRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FeedEntity> getFeedbackById(@PathVariable Long id) {
        Optional<FeedEntity> feedback = feedRepository.findById(id);
        if (feedback.isPresent()) {
            return ResponseEntity.ok(feedback.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FeedEntity createFeedback(@RequestBody FeedEntity feedback) {
        return feedRepository.save(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedEntity> updateFeedback(@PathVariable Long id, @RequestBody FeedEntity updatedFeedback) {
        Optional<FeedEntity> feedback = feedRepository.findById(id);
        if (feedback.isPresent()) {
            updatedFeedback.setId(id);
            return ResponseEntity.ok(feedRepository.save(updatedFeedback));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        Optional<FeedEntity> feedback = feedRepository.findById(id);
        if (feedback.isPresent()) {
            feedRepository.delete(feedback.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
