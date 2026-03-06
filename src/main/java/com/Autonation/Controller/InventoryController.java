package com.Autonation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Inventory;
import com.Autonation.Service.InventoryServices;

@RestController
@RequestMapping("/Inventory")
public class InventoryController {
	@Autowired
	private InventoryServices inventoryservice;

	// Endpoint to add inventory
	
	@PostMapping("/{carId}/add")
  	public ResponseEntity<Inventory> addInventory(@PathVariable Long carId, @RequestParam int quantity) {

		Inventory inventory = inventoryservice.addInventory(carId, quantity);
		if (inventory != null) {
			return new ResponseEntity<>(inventory, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Car not found
	}

    // Endpoint to get inventory by ID
	@GetMapping("/{id}")
	public ResponseEntity<Inventory> getInventoryById(@PathVariable Long id) {
		return inventoryservice.getInventoryById(id).map(inventory -> new ResponseEntity<>(inventory, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// Endpoint to update inventory quantity
	@PutMapping("/{id}/update")
	public ResponseEntity<Inventory> updateInventory(@PathVariable Long id, @RequestParam int newQuantity) {

		Inventory updatedInventory = inventoryservice.updateInventory(id, newQuantity);
		if (updatedInventory != null) {
			return new ResponseEntity<>(updatedInventory, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Inventory not found
	}
}
