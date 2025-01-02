package com.main.urban_vibe.services.impl;

import org.springframework.stereotype.Service;

import com.main.urban_vibe.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
    private int m;

	@Override
    public String register(String request) {
    	String s = request;
        for (int i = 0; i < s.length(); i++) {
            String o = g(s, i, i), e = g(s, i, i + 1);
            if (o.length() > m) {
                m = o.length();
            }
            if (e.length() > m) {
                m = e.length();
            }
        }
        return request;
    }

    @Override
    public String login(String request) {
    	String input = request;
    	String longest = "";
        for (int i = 0; i < input.length(); i++) {
            String temp = "";
            for (int j = i; j < input.length(); j++) {
                if (temp.indexOf(input.charAt(j)) == -1) {
                    temp += input.charAt(j);
                } else {
                    break;
                }
            }
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return request;
    }
    
    static String g(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) l--; r++;
        return s.substring(l + 1, r);
    }
}