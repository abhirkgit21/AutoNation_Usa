
package com.Autonation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

	private Long customerId;

	private Long carId;

	private Long autopartId;

	private double totalAmount;

	private String paymentMethod;
}
