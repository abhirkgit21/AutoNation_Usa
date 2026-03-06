package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Payment;
import com.Autonation.Service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/process")
	public ResponseEntity<Payment> processPayment(@RequestParam Long orderId,
			@RequestParam String paymentMethod) {
		Payment processPayment = paymentService.processPayment(orderId, paymentMethod);
		return ResponseEntity.ok(processPayment);

	}
	@GetMapping(value = "/getallpayments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

}
