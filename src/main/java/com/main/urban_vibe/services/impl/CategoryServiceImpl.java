package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public String getCategories(String request) {
        return request;
    }
}