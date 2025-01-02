package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

    @PostMapping
    public String addRating(@RequestBody String feedbackDto) {
        // No business logic, just return the received DTO
        return feedbackDto;
    }
}