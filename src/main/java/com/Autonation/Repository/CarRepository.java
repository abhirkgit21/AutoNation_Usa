package com.Autonation.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Cars;

@Repository
public interface CarRepository extends JpaRepository<Cars,Long>{

	Optional<Cars> getCarsByCarId(Long carId);

	List<Cars> searchCarsByModel(String model);


	
	

}
