package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Order;
import com.Autonation.DTO.OrderRequest;
import com.Autonation.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/place")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderrequest){
		Order neworder = orderService.placeOrder(orderrequest);
		return new ResponseEntity<>(neworder,HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/getallorders")
	public List<Order> getAllorders() {
		return orderService.getAllOrders();
	}
}

