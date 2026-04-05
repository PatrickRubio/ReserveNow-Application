package com.reservenow.booking;

import com.reservenow.booking.dto.BookingRequest;
import com.reservenow.booking.dto.BookingResponse;
import com.reservenow.listing.Listing;
import com.reservenow.listing.ListingRepository;
import com.reservenow.user.User;
import com.reservenow.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final ListingRepository listingRepository;

    // Required repositories
    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          ListingRepository listingRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
    }

    // Creates booking from incoming request data
    public BookingResponse createBooking(BookingRequest request) {

        // End date must be after start date
        if (!request.getEndDate().isAfter(request.getStartDate())) {
            throw new RuntimeException("End date must be after start date");
        }

        // Find the user by ID
        // If not found, throw an exception
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the listing by ID
        // If not found, throw an exception
        Listing listing = listingRepository.findById(request.getListingId())
                .orElseThrow(() -> new RuntimeException("Listing not found"));

        // Build the new booking object
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setListing(listing);
        booking.setStartDate(request.getStartDate());
        booking.setEndDate(request.getEndDate());

        // New bookings start as PENDING
        booking.setStatus(BookingStatus.PENDING);

        // Save booking to database
        Booking savedBooking = bookingRepository.save(booking);

        // Convert saved entity into response DTO
        return mapToResponse(savedBooking);
    }

    // Returns all bookings as response DTOs
    public List<BookingResponse> getAllBookings() {
        return bookingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Converts Booking entity to BookingResponse DTO
    private BookingResponse mapToResponse(Booking booking) {
        return new BookingResponse(
                booking.getId(),
                booking.getUser().getId(),
                booking.getListing().getId(),
                booking.getStartDate(),
                booking.getEndDate(),
                booking.getStatus(),
                booking.getCreatedAt()
        );
    }
}