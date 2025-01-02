package com.main.urban_vibe.controller;

import com.main.urban_vibe.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public ResponseEntity<String> getProfile(@PathVariable String name) {
        String response = userService.getProfile(name);
        return ResponseEntity.ok(response);
    }
}