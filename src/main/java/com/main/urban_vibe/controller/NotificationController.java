package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/noti")
public class NotificationController {

    @GetMapping
    public String getNotifications(@RequestBody String notification) {
        // No business logic, just return an empty string or a dummy message
        return notification;
    }
}