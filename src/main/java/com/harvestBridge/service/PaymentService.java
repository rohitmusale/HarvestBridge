package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);
	Payment getPaymentById(int id);
	List<Payment> getAllPayment();
	Payment updatePayment(Payment payment);
	void deletePayment(int id);
}
