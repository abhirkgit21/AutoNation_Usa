package com.Autonation.Binding;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	@Column(name = "Payment_Method")
	private String paymentMethod;
	@Column(name = "Payment_Status")
    private String paymentStatus;
	@Column(name = "Amount")
    private Double amount;
	
	private LocalDateTime paymentDate = LocalDateTime.now();
	
	@OneToOne
	@JoinColumn(name = "orderId")
	private Order order;

}
