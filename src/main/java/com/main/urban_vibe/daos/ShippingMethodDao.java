package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.ShippingMethod;
import java.util.List;

public interface ShippingMethodDao {
    List<ShippingMethod> getList();
    ShippingMethod getById(Long id);
    ShippingMethod create(ShippingMethod shippingMethod);
    ShippingMethod update(ShippingMethod shippingMethod);
    void delete(Long id);

    ShippingMethod findByName(String name);
}