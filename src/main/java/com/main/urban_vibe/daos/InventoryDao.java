package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Inventory;
import java.util.List;

public interface InventoryDao {
    List<Inventory> getList();
    Inventory getById(Long id);
    Inventory create(Inventory inventory);
    Inventory update(Inventory inventory);
    void delete(Long id);

    Inventory getInventoryByProductId(Long productId);
    List<Inventory> getInventoriesByUserId(Long userId);
    List<Inventory> getInventoriesByType(String type);
}