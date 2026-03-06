package com.Autonation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.AutonationStore;

@Repository
public interface StoreRepository extends JpaRepository<AutonationStore, Long>{
	

}
