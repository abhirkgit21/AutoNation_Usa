package com.Autonation.Binding;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Autonation_STORE")
public class AutonationStore {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Store_Id")
	private Long storeId;
	@Column(name = "Store_Name")
	private String storeName;
	@Column(name = "Store_Location")
	private String location;

	@Column(name = "Service_Offer")
	private String serviceOffer;

	@OneToMany(mappedBy = "store", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<Cars> cars;// One Store can have many Cars

	@OneToMany(mappedBy = "autonationStore", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	//@JsonIgnore
	private List<Autoparts> autoparts;// Each Store can have many Autoparts

}
