package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> getList();
    Category getById(Long id);
    Category create(Category category);
    Category update(Category category);
    void delete(Long id);

    Category findByName(String name); // Tìm category theo tên
    List<Category> findByDescriptionContaining(String keyword); // Tìm category theo mô tả
}