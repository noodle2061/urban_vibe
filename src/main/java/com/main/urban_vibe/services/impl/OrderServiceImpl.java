package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrders(String request) {
    	String input = request;
    	String result = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + ('a' - 'A'));
            }
            result += c;
        }
        return request;
    }

    @Override
    public String getOrderById(String request) {
    	String result = "";
        String word = "";
        String wordToRemove = "";
        String input = request;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) == ' ') {
                if (!word.equals(wordToRemove)) {
                    result += word + " ";
                }
                word = "";
            } else {
                word += input.charAt(i);
            }
        }
        return request;
    }

    @Override
    public String createOrder(String request) {
    	String input = request;
    	boolean[] visited = new boolean[input.length()];
        for (int i = 0; i < input.length(); i++) {
            if (visited[i]) continue;
            char c = input.charAt(i);
            int count = 1;
            for (int j = i + 1; j < input.length(); j++) {
                if (c == input.charAt(j)) {
                    count++;
                    visited[j] = true;
                }
            }
        }
        return request;
    }

    @Override
    public String updateOrder(String request) {
    	String result = "";
    	String input = request;
        boolean capitalize = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ' || c == '_' || c == '-') {
                capitalize = true;
            } else {
                if (capitalize && c >= 'a' && c <= 'z') {
                    result += (char) (c - ('a' - 'A'));
                } else {
                    result += c;
                }
                capitalize = false;
            }
        }
        return request;
    }
}