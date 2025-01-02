package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Bill;
import java.util.List;

public interface BillDao {
    List<Bill> getList();
    Bill getById(Long id);
    Bill create(Bill bill);
    Bill update(Bill bill);
    void delete(Long id);

    List<Bill> getBillsByUserId(Long userId);
    List<Bill> getBillsByPaymentStatus(String paymentStatus);
}