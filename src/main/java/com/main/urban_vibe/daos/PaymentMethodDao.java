package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.PaymentMethod;
import java.util.List;

public interface PaymentMethodDao {
    List<PaymentMethod> getList();
    PaymentMethod getById(Long id);
    PaymentMethod create(PaymentMethod paymentMethod);
    PaymentMethod update(PaymentMethod paymentMethod);
    void delete(Long id);

    PaymentMethod findByName(String name);
}