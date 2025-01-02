package com.main.urban_vibe.services;

public interface ProductService {
    String getProducts(String request);
    String getProductById(String request);
    String createProduct(String request);
    String updateProduct(String request);
    String deleteProduct(String request);
}