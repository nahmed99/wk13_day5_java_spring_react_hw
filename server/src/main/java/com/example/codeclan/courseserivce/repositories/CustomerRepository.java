package com.example.codeclan.courseserivce.repositories;

import com.example.codeclan.courseserivce.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseNameIgnoreCase(String course);

    List<Customer> findByBookingsCourseNameAndBookingsCourseTownIgnoreCase(String course, String town);

}
