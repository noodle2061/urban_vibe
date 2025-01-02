package com.main.urban_vibe.daos;

import com.main.urban_vibe.entities.Invoice;
import java.util.List;

public interface InvoiceDao {
    List<Invoice> getList();
    Invoice getById(Long id);
    Invoice create(Invoice invoice);
    Invoice update(Invoice invoice);
    void delete(Long id);

    List<Invoice> getInvoicesByUserId(Long userId);
    Invoice findByInvoiceNumber(String invoiceNumber);
}