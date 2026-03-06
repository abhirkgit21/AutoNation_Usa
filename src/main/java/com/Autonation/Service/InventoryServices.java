package com.Autonation.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Cars;
import com.Autonation.Binding.Inventory;
import com.Autonation.Repository.CarRepository;
import com.Autonation.Repository.InventoryRepo;

@Service
public class InventoryServices {
	@Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private CarRepository carRepository;

    // Add a new inventory item
    public Inventory addInventory(Long carId, int quantity) {
        Optional<Cars> carOpt = carRepository.findById(carId);
        if (carOpt.isPresent()) {
            Inventory inventory = new Inventory();
            inventory.setCar(carOpt.get());
            inventory.setQuantityInStock(quantity);
            return inventoryRepo.save(inventory);
        }
        return null; // Car not found
    }

    // Get inventory by ID
    public Optional<Inventory> getInventoryById(Long id) {
        return inventoryRepo.findById(id);
    }

    // Update inventory quantity
    public Inventory updateInventory(Long id, int newQuantity) {
        Optional<Inventory> inventoryOpt = inventoryRepo.findById(id);
        if (inventoryOpt.isPresent()) {
            Inventory inventory = inventoryOpt.get();
            inventory.setQuantityInStock(newQuantity);
            return inventoryRepo.save(inventory);
        }
        return null; // Inventory not found
    }
}


