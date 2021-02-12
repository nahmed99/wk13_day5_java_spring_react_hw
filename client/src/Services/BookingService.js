export const getAllBookings = () => {

    const baseURL = 'http://localhost:8080/bookings/';

    console.log(baseURL);

    return fetch(baseURL)
    .then(res => res.json())

 }