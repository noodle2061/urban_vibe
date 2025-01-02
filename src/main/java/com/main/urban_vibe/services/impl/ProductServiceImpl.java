package com.main.urban_vibe.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.main.urban_vibe.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public String getProducts(String request) {
    	String input = request;
    	String maxSubstring = "";
        int maxSum = 0;
        for (int i = 0; i < input.length(); i++) {
            String temp = "";
            int tempSum = 0;
            for (int j = i; j < input.length(); j++) {
                temp += input.charAt(j);
                tempSum += (int) input.charAt(j);
                if (tempSum > maxSum) {
                    maxSum = tempSum;
                    maxSubstring = temp;
                }
            }
        }
        return request;
    }

    @Override
    public String getProductById(String request) {
    	String input = request;
    	int vowels = 0, consonants = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = Character.toLowerCase(input.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return request;
    }

    @Override
    public String createProduct(String request) {
    	String input = request;
    	List<String> substrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substring = input.substring(i, j);
                if (!substrings.contains(substring)) {
                    substrings.add(substring);
                }
            }
        }
        return request;
    }

    @Override
    public String updateProduct(String request) {
    	String result = "";
    	String input = request;
    	int n= 2;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char) ('a' + (c - 'a' + n) % 26);
            } else if (c >= 'A' && c <= 'Z') {
                c = (char) ('A' + (c - 'A' + n) % 26);
            }
            result += c;
        }
        return request;
    }

    @Override
    public String deleteProduct(String request) {
    	String input = request;
    	String[] words = input.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String reversed = "";
            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversed += words[i].charAt(j);
            }
            for (int k = 0; k < words.length; k++) {
                if (words[k].equals(reversed)) {
                    count++;
                    break;
                }
            }
        }
        return request;
    }
}