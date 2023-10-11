package com.example.store.security.jwt;

import com.example.store.security.jwt.authentication.JwtAuthenticationResponse;
import com.example.store.security.jwt.authentication.SignUpRequest;
import com.example.store.security.jwt.authentication.SigninRequest;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
