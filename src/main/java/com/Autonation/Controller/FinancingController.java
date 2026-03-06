package com.Autonation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Autonation.Binding.Financing;
import com.Autonation.Service.FinancingService;


@RestController
@RequestMapping("/api/financing")
public class FinancingController {

    @Autowired
    private FinancingService financingService;

    @PostMapping("/apply")
    public Financing applyForFinancing(@RequestBody Financing financing) {
        return financingService.applyForLoan(financing);
    }

    @PutMapping("/update-status/{loanId}")
    public Financing updateLoanStatus(
            @PathVariable Long loanId,
            @RequestParam Financing.LoanStatus status) {
        return financingService.updateLoanStatus(loanId, status);
    }

	

    @GetMapping("/status")
    public List<Financing> getLoansByStatus(@RequestParam Financing.LoanStatus status) {
        return financingService.getLoansByStatus(status);
    }
}
