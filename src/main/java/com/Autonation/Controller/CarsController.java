package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Cars;
import com.Autonation.Service.CarServices;

@RestController
@RequestMapping("/cars")
public class CarsController {

	@Autowired
	private CarServices carServices;

	@PostMapping(value = "/addCar", consumes = { "application/json" })
	public ResponseEntity<String> addCar(@RequestBody Cars cars) {

		System.out.println("Save the car to database");
		 carServices.addCar(cars);
		return  ResponseEntity.ok("Cars added successfully");
	}

	@GetMapping(value = "/getallcars")
	public List<Cars> getAllCars() {
		return carServices.getAllCars();

	}

	@GetMapping(value = "/searchCarsByModel")
	public ResponseEntity<List<Cars>> searchCarsByModel(@RequestParam String model) {
		List<Cars> searchCarsModel = carServices.searchCarsByModel(model);
		return ResponseEntity.ok(searchCarsModel);

	}

	@PutMapping("/updateCar/{carId}")
	public ResponseEntity<Cars> updateCar(@PathVariable Long carId, @RequestBody Cars updateCar) {
		Cars car = carServices.updateCars(carId, updateCar);
		return ResponseEntity.ok(car);
	}

	@DeleteMapping("/deleteCar/{carId}")
	public ResponseEntity<String> deleteCar(@PathVariable Long carId) {
		carServices.deleteCar(carId);
		return ResponseEntity.ok("Cars with Id " + carId + " car delete successfully");
	}

}
