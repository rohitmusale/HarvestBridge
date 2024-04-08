package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Order1;

public interface Order1Service {
	Order1 createOrder(Order1 order);
	Order1 getOrderById(int id);
	List<Order1> getAllOrder();
	Order1 updateOrder(Order1 order);
	void deleteOrder(int id);
}
