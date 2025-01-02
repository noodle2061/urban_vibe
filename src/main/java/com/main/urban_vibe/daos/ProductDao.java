package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Product;
import java.util.List;

public interface ProductDao {
    List<Product> getList();
    Product getById(Long id);
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);

    List<Product> findByNameContaining(String keyword);
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findByPriceBetween(double minPrice, double maxPrice);
    List<Product> findByAverageRatingGreaterThanEqual(double rating);
}