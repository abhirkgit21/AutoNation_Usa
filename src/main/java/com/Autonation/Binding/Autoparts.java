package com.Autonation.Binding;

import java.util.List;

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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Autoparts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long autopartId;
	
	@Column(name = "Part_Name")
	private String partName;
	
	@Column(name = "Part_Number")
	private String partNumber;
	
	@Column(name="Part_Price")
	private double partPrice;
	
	@Column(name="Quantity")
	private Integer quantity;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "Store_Id")
	@JsonIgnore
    private AutonationStore autonationStore;
	//Many auto parts can be associated with one store.
	
	@ManyToOne(cascade = CascadeType.ALL)//Many auto parts for one car
	@JoinColumn(name = "car_Id")
	@JsonIgnore
	private Cars cars;
	
	@OneToMany(mappedBy = "autoparts",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> orders;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cart_Id")
	private  Cart cart;
	
	
	
	
	
}
