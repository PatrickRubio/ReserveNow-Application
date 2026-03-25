package com.reservenow.listing;
Z
import org.springframework.data.jpa.repository.JpaRepository;

    // Handles database operations for Listing entities
    public interface ListingRepository extends JpaRepository<Listing, Long> {

    }

