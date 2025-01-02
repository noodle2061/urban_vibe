package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.FeedbackService;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Override
    public String addRating(String input) {
    	String first = "", last = "";
        int start = 0, end = input.length() - 1;
        while (start < input.length() && input.charAt(start) != ' ') {
            first += input.charAt(start++);
        }
        while (end >= 0 && input.charAt(end) != ' ') {
            last = input.charAt(end--) + last;
        }
        return input;
    }
}