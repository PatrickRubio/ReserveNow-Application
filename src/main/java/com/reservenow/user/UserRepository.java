package com.reservenow.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// Handles database access for User entities
public interface UserRepository extends JpaRepository<User, Long> {

    // Query method to find users by email
    Optional<User> findByEmail(String email);

}