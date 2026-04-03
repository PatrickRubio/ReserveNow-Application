package com.reservenow.booking;

import org.springframework.data.jpa.repository.JpaRepository;

// Handles database operations for Booking entities
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
