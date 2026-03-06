package com.Autonation.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Autoparts;
import com.Autonation.Binding.Cars;

@Repository
public interface AutopartsRepo extends JpaRepository<Autoparts,Long>{
	
	    // Optional<Autoparts> autoPartId(Long autopartId);
	
	    List<Autoparts> findByPartName(String partName);

}
