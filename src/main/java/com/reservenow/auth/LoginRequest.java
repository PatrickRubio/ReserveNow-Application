package com.reservenow.auth;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Getter
    @Setter
    private String email;
    private String password;

    public LoginRequest() {
    }
}
