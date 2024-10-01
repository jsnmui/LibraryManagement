package com.example.librarymanagement.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

	@RestController
	public class HomeController {

	    // This maps the root URL ("/") to this method
	    @GetMapping("/")
	    public String home() {
	        return "Welcome to the Library Management System!";
	    }
	}



