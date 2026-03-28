package com.reservenow.listing.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Outgoing response body for listing data
public class ListingResponse {

    private Long id;
    private String title;
    private String description;
    private String location;
    private BigDecimal price;
    private Boolean available;
    private LocalDateTime createdAt;

    public ListingResponse() {
    }

    public ListingResponse(Long id, String title, String description, String location,
                           BigDecimal price, Boolean available, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.price = price;
        this.available = available;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Boolean getAvailable() {
        return available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}