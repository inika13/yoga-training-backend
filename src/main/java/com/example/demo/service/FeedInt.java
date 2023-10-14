package com.example.demo.service;



import com.example.demo.entity.FeedEntity;
import com.example.demo.repository.FeedRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedInt implements FeedService {

    @Autowired
    private FeedRepository feedRepository;

    @Override
    public List<FeedEntity> getAllFeedback() {
        return feedRepository.findAll();
    }

    @Override
    public Optional<FeedEntity> getFeedbackById(Long id) {
        return feedRepository.findById(id);
    }

    @Override
    public FeedEntity createFeedback(FeedEntity feedback) {
        return feedRepository.save(feedback);
    }

    @Override
    public Optional<FeedEntity> updateFeedback(Long id, FeedEntity updatedFeedback) {
        if (feedRepository.existsById(id)) {
            updatedFeedback.setId(id); // Ensure the ID is set for the updated entity
            return Optional.of(feedRepository.save(updatedFeedback));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteFeedback(Long id) {
        feedRepository.deleteById(id);
    }
}

