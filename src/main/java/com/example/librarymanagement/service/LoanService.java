package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Loan;
import com.example.librarymanagement.repository.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // Get all loans
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    // Get a loan by ID
    public Optional<Loan> getLoanById(Long id) {
        return loanRepository.findById(id);
    }

    // Add a new loan
    public Loan addLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    // Update an existing loan
    public Loan updateLoan(Long id, Loan loanDetails) {
        return loanRepository.findById(id).map(loan -> {
            loan.setBook(loanDetails.getBook());
            loan.setBorrower(loanDetails.getBorrower());
            loan.setLoanDate(loanDetails.getLoanDate());
            loan.setReturnDate(loanDetails.getReturnDate());
            return loanRepository.save(loan);
        }).orElseThrow(() -> new RuntimeException("Loan not found with id " + id));
    }

    // Delete a loan
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}
