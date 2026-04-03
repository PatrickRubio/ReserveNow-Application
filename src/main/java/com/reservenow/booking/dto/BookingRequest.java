package com.reservenow.booking.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

// Request body for creating a booking
public class BookingRequest {

    // User making the booking
    @NotNull(message = "User ID is required")
    private Long userId;

    // Listing being booked
    @NotNull(message = "Listing ID is required")
    private Long listingId;

    // Booking start date must be today or later
    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be today or in the future")
    private LocalDate startDate;

    // Booking end date is required
    @NotNull(message = "End date is required")
    private LocalDate endDate;

    public BookingRequest() {
    }
    // Getters and Setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getListingId() {
        return listingId;
    }
    public void setListingId(Long listingId) {
        this.listingId = listingId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}