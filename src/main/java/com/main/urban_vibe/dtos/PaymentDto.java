package com.main.urban_vibe.dtos;

import com.main.urban_vibe.enums.PaymentStatus;

public class PaymentDto {

    private Long orderId;
    private float amount;
    private PaymentStatus status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}