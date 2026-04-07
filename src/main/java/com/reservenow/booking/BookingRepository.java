package com.reservenow.booking;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByListingIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            Long listingId,
            LocalDate endDate,
            LocalDate startDate
    );
}