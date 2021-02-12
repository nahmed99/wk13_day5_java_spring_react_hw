package com.example.codeclan.courseserivce.controllers;

import com.example.codeclan.courseserivce.models.Customer;
import com.example.codeclan.courseserivce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value="/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name="course", required = false) String course,
            @RequestParam(name="town", required = false) String town
    ) {

        if (course != null && town != null) {
            List<Customer> allCustomersOnCourse = customerRepository.findByBookingsCourseNameAndBookingsCourseTownIgnoreCase(course, town);
            return new ResponseEntity<>(allCustomersOnCourse, HttpStatus.OK);
        }

        // Get all customer on a specific course.
        if (course != null) {
            List<Customer> allCustomersOnCourse = customerRepository.findByBookingsCourseNameIgnoreCase(course);
            return new ResponseEntity<>(allCustomersOnCourse, HttpStatus.OK);
        }

        // GET all customers
        List<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

}
