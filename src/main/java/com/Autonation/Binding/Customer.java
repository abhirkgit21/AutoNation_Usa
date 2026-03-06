package com.Autonation.Binding;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "Cust_Id")
	private Long customerId;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Email_Address", unique = true)
	private String emailAddress;

	// @NotEmpty(message = "Phone Number is required")
	// @Size(min = 10, message = "Phone should at least 10 digits")
	private Long phoneNo;

	// @Size(min = 5)
	private Integer zipCode;

	// @Size(min = 8)
	//@NotEmpty(message = "Password Must be required")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	@ToString.Exclude
	private List<Order> orders;
	
	
	
	
	
	
	

	/*
	 * @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) private
	 * List<Cars> cars;// One customer has a group of cars
	 */
	/*
	 * @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) private
	 * List<OldCars> oldCars;// One customer sell multiple old cars
	 */
	/*
	 * @ManyToMany(cascade = CascadeType.ALL) // fetch type lazy by default
	 * 
	 * @JoinTable(name = "Custmer_Autoparts_tables", joinColumns = @JoinColumn(name
	 * = "Cust_Id"), inverseJoinColumns = @JoinColumn(name = "partId")) private
	 * List<Autoparts> autoparts;
	 * 
	 * @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) private
	 * List<Carts> carts;
	 * 
	 * @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) private
	 * List<AutonationStore> autonationStores;// One customer has many stores
	 * 
	 * @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL) private
	 * List<SellCars> sellcars;
	 */

}