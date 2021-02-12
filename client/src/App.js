import { useEffect, useState } from 'react';
import './App.css';
import {getCourses} from "./Services/CourseService";
import {getCustomers} from "./Services/CustomerService";
import {getAllBookings} from "./Services/BookingService";


function App() {

  const[courses, setCourses] = useState([]);
  const[customers, setCustomers] = useState([]);
  const[bookings, setBookings] = useState([]);


  useEffect(() => {

    let customer = "";
    let starRating = "";

    customer = "Sid Sloth";
    // starRating = "4";

    getCourses(customer, starRating)
    .then((courses) => {
      setCourses(courses);
    
      console.log("Courses: ");
      console.log(courses);
    })
  }, []);


  useEffect(() => {

    let course = "";
    let town = ""

    // course = "Intro To Java";
    // town = "Edinburgh";

    getCustomers(course, town)
    .then((customers) => {
      setCustomers(customers);
      console.log("Customers: ")
    console.log(customers);
    })
  }, []);


  useEffect(() => {

    getAllBookings()
    .then((bookings) => {
      setBookings(bookings);
      console.log("All bookings: ")
    console.log(bookings);
    })
  }, []);

 
  return (
    <div className="App">
      <p>This is the beginning of my front-end...</p>
    </div>
  );
}

export default App;
