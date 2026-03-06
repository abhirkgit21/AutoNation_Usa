package com.Autonation.Binding;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_Order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;

	@Column(name = "Order_Status")
	private String orderStatus;

	@Column(name = "Total_Amount")
	private Double totalAmount;

	/*
	 * @Column(name = "orderName") private String orderName;
	 */

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Customer_Id")
	@JsonIgnore
	private Customer customer;// One customer can place many orders.
								// Each order is associated with a single customer.


	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "car_id")
	 * 
	 * @JsonIgnore private Cars cars;
	 */

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "autopart_id")
	@JsonIgnore
	private Autoparts autoparts;
	
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private Payment payment;// Each order is associated with one payment.
							// Each payment corresponds to one order.

}
