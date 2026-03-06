package com.Autonation.Binding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cars")
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long carId;

	@Column(name = "Locations")
	private String location;

	@Column(name = "Year")
	private Integer year;

	@Column(name = "Any_Make")
	private String anyMake;

	@Column(name = "Model")
	private String model;

	@Column(name = "Body_Style")
	private String bodyStyle;

	@Column(name = "Price")
	private double price;

	@Column(name = "Exterior_Colour")
	private String exteriorColour;

	@Column(name = "Interior_Material")
	private String interiorMaterial;

	@Column(name = "Fuel_Type")
	private String fuelType;

	@Column(name = "Transmission")
	private String transmission;

	@Lob
	@Column(name = "Cars_Image")
	private String carsImage;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Store_Id")
	// @JsonBackReference
	private AutonationStore store;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cars") // Many cars can belong to one store.
	private List<Autoparts> autoparts;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Cart_Id")
	@JsonIgnore
	private Cart cart;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Inventory> inventories;
}
