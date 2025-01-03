package com.main.urban_vibe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/noti")
public class NotificationController {

    @GetMapping
    public ResponseEntity<String> getNotifications(@RequestBody String notiRequest) {
        return ResponseEntity.ok(notiRequest);
    }
}