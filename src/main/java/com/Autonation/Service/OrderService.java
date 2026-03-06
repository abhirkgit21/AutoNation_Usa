package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Autoparts;
import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Customer;
import com.Autonation.Binding.Order;
import com.Autonation.Binding.Payment;
import com.Autonation.DTO.OrderRequest;
import com.Autonation.Repository.AutopartsRepo;
import com.Autonation.Repository.CarRepository;
import com.Autonation.Repository.CustomerRepo;
import com.Autonation.Repository.OrderRepo;
import com.Autonation.Repository.PaymentRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private AutopartsRepo autopartsRepo;

	@Autowired
	private PaymentRepo paymentRepo;

	public Order placeOrder(OrderRequest orderRequest) {

		Customer customer = customerRepo.findById(orderRequest.getCustomerId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		Cars car = carRepository.findById(orderRequest.getCarId())
				.orElseThrow(() -> new RuntimeException("Car not found"));

		Autoparts autoPart = autopartsRepo.findById(orderRequest.getAutopartId())
				.orElseThrow(() -> new RuntimeException("Part not found"));

		Order order = new Order();
		order.setCustomer(customer);
		// order.setCars(car);
		order.setAutoparts(autoPart);
		order.setTotalAmount(orderRequest.getTotalAmount());
		order.setOrderStatus("Pending");

		// Save the order
		Order savedOrder = orderRepo.save(order);

		return savedOrder;
	}

	public List<Order> getAllOrders() {
		List<Order> list = orderRepo.findAll();
		if (list == null)
			throw new RuntimeException("No car Found..!");
		return list;
	}

}
