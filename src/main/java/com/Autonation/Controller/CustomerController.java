package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Customer;
import com.Autonation.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/add", consumes = { "application/json" })
	public ResponseEntity<String> addCar(@RequestBody Customer customer) {

		System.out.println("Save the car to database");

		customerService.addCustomer(customer);
		return ResponseEntity.ok("Customer added successfully");
	}

	@GetMapping(value = "/getallcustomer")
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();

	}

}
