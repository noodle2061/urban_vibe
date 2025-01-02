package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Payment;
import java.util.List;

public interface PaymentDao {
    List<Payment> getList();
    Payment getById(Long id);
    Payment create(Payment payment);
    Payment update(Payment payment);
    void delete(Long id);

    List<Payment> getPaymentsByOrderId(Long orderId);
    List<Payment> getPaymentsByUserId(Long userId);
    List<Payment> getPaymentsByStatus(String status);
}