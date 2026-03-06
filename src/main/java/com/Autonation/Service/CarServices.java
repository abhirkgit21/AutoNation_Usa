package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Cars;
import com.Autonation.Repository.CarRepository;

@Service
public class CarServices {

	@Autowired
	private CarRepository carRepository;

	public Cars addCar(Cars car) {// save a new cars into database

		return carRepository.save(car);

	}

	public Cars getCarsByCarId(Long carId) {
		System.out.println("getCars By Id");
		return carRepository.getCarsByCarId(carId).orElseThrow(() -> new RuntimeException("CarId not found"));

	}

	public List<Cars> getAllCars() {
		List<Cars> list = carRepository.findAll();
		if (list == null)
			throw new RuntimeException("No car Found..!");
		return list;
	}

	public List<Cars> searchCarsByModel(String model) {
		return carRepository.searchCarsByModel(model);
	}

	public Cars updateCars(Long carId, Cars updateCar) {
		Cars availablecar = carRepository.findById(carId).orElseThrow(() -> new RuntimeException("Car not found"));
		availablecar.setLocation(updateCar.getLocation());
		availablecar.setPrice(updateCar.getPrice());
		availablecar.setExteriorColour(updateCar.getExteriorColour());
		availablecar.setModel(updateCar.getModel());
		return carRepository.save(availablecar);

	}

	public void deleteCar(Long carId) {
		carRepository.deleteById(carId);

	}

}
