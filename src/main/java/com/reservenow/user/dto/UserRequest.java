package com.reservenow.user.dto;

import com.reservenow.user.Role;

// Incoming request body for creating a new user
public class UserRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;

    public UserRequest() {
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // Password comes in from the user, but will not send it back
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}