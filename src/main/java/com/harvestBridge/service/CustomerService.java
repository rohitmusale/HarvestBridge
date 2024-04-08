package com.harvestBridge.service;

import java.util.List;

import com.harvestBridge.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomer();
	Customer updateCustomer(Customer customer);
	void deleteCustomer(int id);

}
