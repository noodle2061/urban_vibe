package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Override
    public String getCart(String request) {
        return request;
    }

    @Override
    public String updateCart(String request) {
        return request;
    }
}