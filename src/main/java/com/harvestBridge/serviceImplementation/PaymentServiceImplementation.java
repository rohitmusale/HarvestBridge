package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Payment;
import com.harvestBridge.repository.PaymentRepository;
import com.harvestBridge.service.PaymentService;

@Service
public class PaymentServiceImplementation implements PaymentService {
	@Autowired
	PaymentRepository paymentRepo;
	
	@Override
	public Payment createPayment(Payment payment) {
		Payment pay = paymentRepo.save(payment);
		return pay;
	}

	@Override
	public Payment getPaymentById(int id) {
		Optional<Payment> pay1 = paymentRepo.findById(id);
		
		if(pay1.isPresent()) {
			return pay1.get();		
		}
		return null;
	}

	@Override
	public List<Payment> getAllPayment() {
		return paymentRepo.findAll();
	}

	@Override
	public Payment updatePayment(Payment payment) {
		Payment existingPayment = paymentRepo.findById(payment.getPayID()).get();
		existingPayment.setPayPrice(payment.getPayPrice());
		
		
		Payment updatePayment = paymentRepo.save(existingPayment);
		return updatePayment;
	}

	@Override
	public void deletePayment(int id) {
		paymentRepo.deleteById(id);
		
	}
}
