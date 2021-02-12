package com.example.codeclan.courseserivce.controllers;

import com.example.codeclan.courseserivce.models.Booking;
import com.example.codeclan.courseserivce.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value="/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(name="date", required = false) String date
    ) {

        if (date != null) {
            List<Booking> allBookingsForDate = bookingRepository.getBookingsByDate(date);
            return new ResponseEntity<>(allBookingsForDate, HttpStatus.OK);
        }

        // GET all bookings
        List<Booking> allBookings = bookingRepository.findAll();
        return new ResponseEntity<>(allBookings, HttpStatus.OK);
    }

}
