package com.Autonation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Payment;
@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
