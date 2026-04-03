package com.reservenow.booking.dto;

import com.reservenow.booking.BookingStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Outgoing response body for booking data
public class BookingResponse {

    private Long id;
    private Long userId;
    private Long listingId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BookingStatus status;
    private LocalDateTime createdAt;

    public BookingResponse() {
    }

    // Constructor for BookingResponse class
    public BookingResponse(Long id, Long userId, Long listingId,
                           LocalDate startDate, LocalDate endDate,
                           BookingStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.listingId = listingId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.createdAt = createdAt;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }
    public Long getListingId() {
        return listingId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public BookingStatus getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}