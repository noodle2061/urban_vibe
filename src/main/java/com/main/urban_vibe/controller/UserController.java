package com.main.urban_vibe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/{name}")
    public String getProfile(@PathVariable String name) {
        // No business logic, just return a dummy user or an empty object
        return name;
    }
}