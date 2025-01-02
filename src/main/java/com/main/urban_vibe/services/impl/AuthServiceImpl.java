package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public String register(String request) {
        return request;
    }

    @Override
    public String login(String request) {
        return request;
    }
}