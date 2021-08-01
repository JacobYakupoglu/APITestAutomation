I automated 5 different APIs which are "createBooking", "getBookingById", "partialUpdateBooking", "deleteBooking" and "getBookingIds".

createBooking - Test code creates a booking and checks for if the API returns 200 OK.

getBookingById - Test code checks the booking that we have created and checks for if the API returns 200 OK.

partialUpdateBooking - Test code creates a booking and updates that particular booking information and checks for if the API returns 200 OK.

deleteBooking - Test code creates a booking and deletes that particular booking and checks for if the API returns 201 Created.

getBookingByIds - Test code checks all the bookings and checks for if the API returns 200 OK.


There is a java file which is called "BaseTest". It contains baseURL. createBooking, getBookingById, partialUpdateBooking, deleteBooking and getBookingByIds java files extends from "BaseTest".

There is a method java file and it returns created bookings.


