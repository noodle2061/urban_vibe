package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.ShippingDetail;
import java.util.List;

public interface ShippingDetailDao {
    List<ShippingDetail> getList();
    ShippingDetail getById(Long id);
    ShippingDetail create(ShippingDetail shippingDetail);
    ShippingDetail update(ShippingDetail shippingDetail);
    void delete(Long id);

    List<ShippingDetail> getShippingDetailsByOrderId(Long orderId);
}