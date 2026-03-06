package com.Autonation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Autonation.Binding.Financing;
import com.Autonation.Repository.FinancingRepository;

@Service
public class FinancingService {
	
	@Autowired
	private FinancingRepository financingRepository;

	public Financing applyForLoan(Financing financing) {
		financing.setStatus(Financing.LoanStatus.PENDING);
		return financingRepository.save(financing);
	}

	public Financing updateLoanStatus(Long loanId, Financing.LoanStatus status) {
		Financing financing = financingRepository.findById(loanId)
				.orElseThrow(() -> new RuntimeException("Loan not found"));
		financing.setStatus(status);
		return financingRepository.save(financing);
	}

	/*
	 * public List<Financing> getUserLoans(Long customerId) { return
	 * financingRepository.findByCustomerId(customerId); }
	 */

	public List<Financing> getLoansByStatus(Financing.LoanStatus status) {
		return financingRepository.findByStatus(status);
	}
}
