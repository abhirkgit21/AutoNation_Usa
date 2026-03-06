package com.Autonation.Binding;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Financing")
public class Financing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String loanNumber;
	private Double loanAmount;
	private Double interestRate;
	private Integer termInMonths;
	private LocalDate startDate;
	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	private LoanStatus status;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Cars cars;

	public enum LoanStatus {
		PENDING, APPROVED, REJECTED, CLOSED
	}

}
