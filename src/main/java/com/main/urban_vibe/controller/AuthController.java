package com.main.urban_vibe.controller;

import com.main.urban_vibe.dtos.auth.AuthenticationRequest;
import com.main.urban_vibe.dtos.auth.RegisterRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // No business logic, just return success
        return ResponseEntity.ok().body("{\"success\": true}");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {
        // No business logic, just return the received request
        return ResponseEntity.ok(request);
    }
}