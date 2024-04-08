package com.harvestBridge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harvestBridge.entity.Order1;
import com.harvestBridge.service.Order1Service;

import jakarta.validation.Valid;

@RestController
public class Order1Controller {
	@Autowired
	Order1Service orderService;
	
	@PostMapping("/order")
	public Order1 saveOrder(@Valid @RequestBody Order1 order) {
		return orderService.createOrder(order);
	}
	
	@GetMapping("/order/{id}")
	public Order1 getOrderById(@PathVariable("id")int id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping("order/getAllData")
	public List<Order1> getAllOrder(){
		List<Order1> order = orderService.getAllOrder();
		return order;
	}
	
	@PutMapping("/order/update/{id}")
	public Order1 updateOrder(@PathVariable("id") int id, @RequestBody Order1 order) {
		order.setOID(id);
		Order1 updateOrder = orderService.updateOrder(order);
		return updateOrder;
	}
	
	@DeleteMapping("/order/delete/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);
		System.out.println("Delete from order table Successfully");
	}
}
