package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Borrower;
import com.example.librarymanagement.repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    private final BorrowerRepository borrowerRepository;

    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    // Get all borrowers
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    // Get a borrower by ID
    public Optional<Borrower> getBorrowerById(Long id) {
        return borrowerRepository.findById(id);
    }

    // Add a new borrower
    public Borrower addBorrower(Borrower borrower) {
        return borrowerRepository.save(borrower);
    }

    // Update an existing borrower
    public Borrower updateBorrower(Long id, Borrower borrowerDetails) {
        return borrowerRepository.findById(id).map(borrower -> {
            borrower.setName(borrowerDetails.getName());
            return borrowerRepository.save(borrower);
        }).orElseThrow(() -> new RuntimeException("Borrower not found with id " + id));
    }

    // Delete a borrower
    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }
}
