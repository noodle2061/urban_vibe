package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.ProductImage;
import java.util.List;

public interface ProductImageDao {
    List<ProductImage> getList();
    ProductImage getById(Long id);
    ProductImage create(ProductImage productImage);
    ProductImage update(ProductImage productImage);
    void delete(Long id);

    List<ProductImage> getProductImagesByProductId(Long productId);
    ProductImage findByImageUrl(String imageUrl);
}