package com.main.urban_vibe.services.impl;

import com.main.urban_vibe.services.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public String getProducts(String request) {
        return request;
    }

    @Override
    public String getProductById(String request) {
        return request;
    }

    @Override
    public String createProduct(String request) {
        return request;
    }

    @Override
    public String updateProduct(String request) {
        return request;
    }

    @Override
    public String deleteProduct(String request) {
        return request;
    }
}