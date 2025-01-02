package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Override
    public String getCategories(String request) {
    	String input = request;
    	String[] words = new String[input.length()];
        int wordCount = 0;
        String word = "";
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                if (!word.isEmpty()) {
                    words[wordCount++] = word;
                    word = "";
                }
            } else {
                word += input.charAt(i);
            }
        }
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }
        return request;
    }
}