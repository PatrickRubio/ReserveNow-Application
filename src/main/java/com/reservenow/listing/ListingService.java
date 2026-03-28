package com.reservenow.listing;

import com.reservenow.listing.dto.ListingRequest;
import com.reservenow.listing.dto.ListingResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {

    private final ListingRepository listingRepository;

    // Spring injects the repository
    public ListingService(ListingRepository listingRepository) {
        this.listingRepository = listingRepository;
    }

    // New listing from the incoming request DTO
    public ListingResponse createListing(ListingRequest request) {
        Listing listing = new Listing();

        // Map request DTO -> entity
        listing.setTitle(request.getTitle());
        listing.setDescription(request.getDescription());
        listing.setLocation(request.getLocation());
        listing.setPrice(request.getPrice());
        listing.setAvailable(request.getAvailable());

        Listing savedListing = listingRepository.save(listing);

        // Map saved entity -> response DTO
        return mapToResponse(savedListing);
    }

    // Returns all listings as response DTOs
    public List<ListingResponse> getAllListings() {
        return listingRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // Converts entity to response DTO
    private ListingResponse mapToResponse(Listing listing) {
        return new ListingResponse(
                listing.getId(),
                listing.getTitle(),
                listing.getDescription(),
                listing.getLocation(),
                listing.getPrice(),
                listing.getAvailable(),
                listing.getCreatedAt()
        );
    }
}