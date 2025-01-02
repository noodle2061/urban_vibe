package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.ProductTag;
import java.util.List;

public interface ProductTagDao {
    List<ProductTag> getList();
    ProductTag getById(Long id);
    ProductTag create(ProductTag productTag);
    ProductTag update(ProductTag productTag);
    void delete(Long id);

    List<ProductTag> getProductTagsByProductId(Long productId);
    List<ProductTag> getProductTagsByTagId(Long tagId);
}