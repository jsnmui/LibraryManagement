package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Borrower;
import com.example.librarymanagement.service.BorrowerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowers")
public class BorrowerController {

   
    private final BorrowerService borrowerService;
    
    public BorrowerController(BorrowerService borrowerService) {
	   this.borrowerService = borrowerService;
	}

	@GetMapping
    public ResponseEntity<List<Borrower>> getAllBorrowers() {
        return new ResponseEntity<>(borrowerService.getAllBorrowers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Borrower> addBorrower(@RequestBody Borrower borrower) {
        return new ResponseEntity<>(borrowerService.addBorrower(borrower), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @RequestBody Borrower borrower) {
        return new ResponseEntity<>(borrowerService.updateBorrower(id, borrower), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
