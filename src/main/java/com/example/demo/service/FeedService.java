package com.example.demo.service;



import com.example.demo.entity.FeedEntity;

import java.util.List;
import java.util.Optional;

public interface FeedService {
    List<FeedEntity> getAllFeedback();
    Optional<FeedEntity> getFeedbackById(Long id);
    FeedEntity createFeedback(FeedEntity feedback);
    Optional<FeedEntity> updateFeedback(Long id, FeedEntity updatedFeedback);
    void deleteFeedback(Long id);
}

