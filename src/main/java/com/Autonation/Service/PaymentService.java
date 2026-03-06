package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Autonation.Binding.Customer;
import com.Autonation.Binding.Order;
import com.Autonation.Binding.Payment;
import com.Autonation.Repository.CustomerRepo;
import com.Autonation.Repository.OrderRepo;
import com.Autonation.Repository.PaymentRepo;

@Service
public class PaymentService {
	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private CustomerRepo customerRepo;

	@Transactional
	public Payment processPayment(Long orderId, String paymentMethod) {


		Order order = orderRepo.findById(orderId).orElseThrow(() -> new RuntimeException("order Not Found"));
		

		// Find the customer by customerId, throw an exception if not found
		Customer customer = order.getCustomer();
		if (customer == null)
			throw new RuntimeException("Customer Not Found");
		System.err.println("Setting the customer ");

		order.setCustomer(customer);// Set the customer for the order

		// Save the order in the database

         //creates a payment  and links it to the created order.
		System.err.println("creating object for the payment");
		Payment payment = new Payment();
		payment.setAmount(order.getTotalAmount());
		payment.setPaymentStatus("Completed");
		// payment.setPaymentStatus("Processing");
		payment.setPaymentMethod(paymentMethod);
		System.err.println("Setting the orer for the paymnet");
		payment.setOrder(order);

		System.err.println("Making payment save payment");
		Payment paymentsave = paymentRepo.save(payment);
		
		System.err.println("Payment saved successfully");

		order.setOrderStatus("Completed");
		System.err.println("Update order statsus");
		orderRepo.save(order);

		// paymentRepo.save(paymentsave);
		return paymentsave;// method returns the savedPayment,
		

	}
	public List<Payment> getAllPayments() {
		List<Payment> list = paymentRepo.findAll();
		if (list == null)
			throw new RuntimeException("No car Found..!");
		return list;
	}
}
