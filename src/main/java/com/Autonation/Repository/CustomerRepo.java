package com.Autonation.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Customer;

@Repository
//@EnableJpaRepositories
public interface CustomerRepo  extends JpaRepository<Customer, Long> {

	Customer findByEmailAddress(String emailAddress);

	//Optional<Customer> findById(Long customerId);
	
  Optional<Customer> findByEmailAddressAndPassword(String emailAddress,String Password);
}
