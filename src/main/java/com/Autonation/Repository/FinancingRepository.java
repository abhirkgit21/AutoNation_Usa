package com.Autonation.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Autonation.Binding.Financing;

@Repository
public interface FinancingRepository extends JpaRepository<Financing, Long>{
	
    List<Financing> findByStatus(Financing.LoanStatus status);
}
