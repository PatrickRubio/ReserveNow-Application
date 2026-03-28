package com.reservenow.listing;

import com.reservenow.listing.dto.ListingRequest;
import com.reservenow.listing.dto.ListingResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
public class ListingController {

    private final ListingService listingService;

    // Spring injects the service with constructor
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    // Creates a new listing
    @PostMapping
    public ListingResponse createListing(@Valid @RequestBody ListingRequest request) {
        return listingService.createListing(request);
    }

    // Returns all listings
    @GetMapping
    public List<ListingResponse> getAllListings() {
        return listingService.getAllListings();
    }
}