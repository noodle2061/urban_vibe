package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public String getProfile(String request) {
    	String word = "";
    	String input = request;
        String longest = "";
        int longestCount = 0;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                if (word.length() > longest.length()) {
                    longest = word;
                    longestCount = 1;
                } else if (word.equals(longest)) {
                    longestCount++;
                }
                word = "";
            } else {
                word += input.charAt(i);
            }
        }
        return request;
    }
}