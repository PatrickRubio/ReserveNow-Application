package com.reservenow.booking;

import com.reservenow.booking.dto.BookingRequest;
import com.reservenow.booking.dto.BookingResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    // Spring injects BookingService automatically
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Creates a new booking
    @PostMapping
    public BookingResponse createBooking(@Valid @RequestBody BookingRequest request) {
        return bookingService.createBooking(request);
    }

    // Returns all bookings
    @GetMapping
    public List<BookingResponse> getAllBookings() {
        return bookingService.getAllBookings();
    }
}