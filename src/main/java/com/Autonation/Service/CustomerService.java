package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Customer;
import com.Autonation.Repository.CarRepository;
import com.Autonation.Repository.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CarRepository carRepository;

	public String addCustomer(Customer customer) {// save a new customer into database
		customerRepo.save(customer);
		return "Customer add successfully";
	}

	public List<Customer> getAllCustomer() { // find all customer
		return customerRepo.findAll();
	}


	
	public Customer findCustomerById(Long customer) {
		return customerRepo.findById(customer).orElseThrow(() -> new RuntimeException("Customer not found"));
	}
	

}
