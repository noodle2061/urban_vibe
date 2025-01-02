package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public String getCart(String request) {
    	String input = request;
    	for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                System.out.println("loi");
            }
        }
        return request;
    }

    @Override
    public String updateCart(String request) {
    	String input = request;
    	String longest = "";
        String word = "";
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                if (word.length() > longest.length()) {
                    longest = word;
                }
                word = "";
            } else {
                word += input.charAt(i);
            }
        }
        return request;
    }
}