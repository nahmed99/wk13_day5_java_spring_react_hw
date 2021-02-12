package com.example.codeclan.courseserivce.components;

import com.example.codeclan.courseserivce.models.Booking;
import com.example.codeclan.courseserivce.models.Course;
import com.example.codeclan.courseserivce.models.Customer;
import com.example.codeclan.courseserivce.repositories.BookingRepository;
import com.example.codeclan.courseserivce.repositories.CourseRepository;
import com.example.codeclan.courseserivce.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    // Default constructor for Srping
    public DataLoader(){
    }

    public void run(ApplicationArguments args) {
        Course course1 = new Course("Intro To Python", "Glasgow", 4);
        courseRepository.save(course1);
        Course course2 = new Course("Intro To Java", "Edinburgh", 5);
        courseRepository.save(course2);
        Course course3 = new Course("Intro To JavaScript", "Edinburgh", 3);
        courseRepository.save(course3);
        Course course4 = new Course("Advanced React", "Aberdeen", 4);
        courseRepository.save(course4);
        Course course5 = new Course("AWS", "Athens", 2);
        courseRepository.save(course5);

        Customer customer1 = new Customer("Sid Sloth", "Largs", 32);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Manny Mammoth", "Govan", 39);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Diego Sabre", "Bearsden", 28);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Eli Mammoth", "Govan", 25);
        customerRepository.save(customer4);

        Customer customer5 = new Customer("Scrat", "ben Nevis", 18);
        customerRepository.save(customer5);


        Booking booking1 = new Booking("15-01-2021", customer1, course1);
        bookingRepository.save(booking1);
        Booking booking2 = new Booking("15-01-2021", customer2, course2);
        bookingRepository.save(booking2);
        Booking booking3 = new Booking("15-01-2021", customer3, course3);
        bookingRepository.save(booking3);
        Booking booking4 = new Booking("15-01-2021", customer4, course4);
        bookingRepository.save(booking4);
        Booking booking5 = new Booking("15-01-2021", customer5, course5);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("15-02-2020", customer1, course3);
        bookingRepository.save(booking6);
        Booking booking7 = new Booking("15-02-2020", customer2, course1);
        bookingRepository.save(booking7);
        Booking booking8 = new Booking("15-02-2020", customer3, course5);
        bookingRepository.save(booking8);
        Booking booking9 = new Booking("15-02-2020", customer4, course3);
        bookingRepository.save(booking9);
        Booking booking10 = new Booking("15-02-2020", customer5, course2);
        bookingRepository.save(booking10);

    }

}
