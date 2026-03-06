package com.Autonation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

	
  //List<Order> findByCustomerId(Long customerId);
}
