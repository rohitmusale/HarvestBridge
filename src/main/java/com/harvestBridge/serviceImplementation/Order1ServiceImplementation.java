package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harvestBridge.entity.Order1;
import com.harvestBridge.repository.Order1Repository;
import com.harvestBridge.service.Order1Service;

@Service
public class Order1ServiceImplementation implements Order1Service {
	@Autowired
	Order1Repository orderRepo;
	
	@Override
	public Order1 createOrder(Order1 order) {
		Order1 ord = orderRepo.save(order);
		return ord;
	}

	@Override
	public Order1 getOrderById(int id) {
		Optional<Order1> ord1 = orderRepo.findById(id);
		
		if(ord1.isPresent()) {
			return ord1.get();		
		}
		return null;
	}

	@Override
	public List<Order1> getAllOrder() {
		return orderRepo.findAll();
	}

	@Override
	public Order1 updateOrder(Order1 order) {
		Order1 existingOrder = orderRepo.findById(order.getOID()).get();
		existingOrder.setOAddress(order.getOAddress());
		existingOrder.setOItems(order.getOItems());
		existingOrder.setOPrice(order.getOPrice());
		
		existingOrder.setPayMethod(order.getPayMethod());
		
		Order1 updateOrder = orderRepo.save(existingOrder);
		return updateOrder;
	}

	@Override
	public void deleteOrder(int id) {
		orderRepo.deleteById(id);
		
	}
}
