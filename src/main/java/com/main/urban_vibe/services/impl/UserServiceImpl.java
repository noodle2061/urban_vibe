package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getProfile(String request) {
        return request;
    }
}