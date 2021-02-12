package com.example.codeclan.courseserivce.controllers;

import com.example.codeclan.courseserivce.models.Course;
import com.example.codeclan.courseserivce.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false) Integer starRating,
            @RequestParam(name="customer", required = false) String customer
    ) {

        if (starRating != null) {
            List<Course> allCoursesForRating = courseRepository.findByStarRating(starRating);
            return new ResponseEntity<>(allCoursesForRating, HttpStatus.OK);
        }

        if (customer != null) {
            List<Course> allCoursesForCustomer = courseRepository.findByBookingsCustomerNameIgnoreCase(customer);
            return new ResponseEntity<>(allCoursesForCustomer, HttpStatus.OK);
        }

        // GET all courses
        List<Course> allCourses = courseRepository.findAll();
        return new ResponseEntity<>(allCourses, HttpStatus.OK);
    }

}
