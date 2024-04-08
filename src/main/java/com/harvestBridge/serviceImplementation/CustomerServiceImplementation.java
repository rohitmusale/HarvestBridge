package com.harvestBridge.serviceImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.harvestBridge.entity.Customer;
import com.harvestBridge.repository.CustomerRepository;
import com.harvestBridge.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService{
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		Customer cst = customerRepo.save(customer);
		return cst;
	}

	@Override
	public Customer getCustomerById(int id) {
		Optional<Customer> cst1 = customerRepo.findById(id);
		
		if(cst1.isPresent()) {
			return cst1.get();		
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepo.findById(customer.getCID()).get();
		existingCustomer.setCName(customer.getCName());
		existingCustomer.setCEmail(customer.getCEmail());
		existingCustomer.setCMobNo(customer.getCMobNo());
		existingCustomer.setCAddress(customer.getCAddress());
		
		Customer updateCustomer = customerRepo.save(existingCustomer);
		return updateCustomer;
	}

	@Override
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
		
	}

}
