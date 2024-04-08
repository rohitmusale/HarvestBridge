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

import com.harvestBridge.entity.Customer;
import com.harvestBridge.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer")
	public Customer saveCustomer(@Valid @RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	@GetMapping("/customer/{id}")
	public Customer getCustomerById(@PathVariable("id")int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("customer/getAllData")
	public List<Customer> getAllCustomer(){
		List<Customer> customer = customerService.getAllCustomer();
		return customer;
	}
	
	@PutMapping("/customer/update/{id}")
	public Customer updateCustomer(@Valid @PathVariable("id") int id, @RequestBody Customer customer) {
		customer.setCID(id);
		Customer updateCustomer = customerService.updateCustomer(customer);
		return updateCustomer;
	}
	
	@DeleteMapping("/customer/delete/{id}")
	public void deleteCustomer(@PathVariable int id) {
		customerService.deleteCustomer(id);
		System.out.println("Delete from customer table Successfully");
	}
}
