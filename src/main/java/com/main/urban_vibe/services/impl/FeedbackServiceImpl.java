package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public String addRating(String request) {
        return request;
    }
}