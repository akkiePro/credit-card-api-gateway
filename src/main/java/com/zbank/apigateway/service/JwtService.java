package com.zbank.apigateway.service;

import com.zbank.apigateway.model.dto.AuthenticationRequest;
import com.zbank.apigateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired private JwtUtil jwtUtil;

    public String createJwtToken(AuthenticationRequest request) throws Exception {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getCardNumber(), request.getPin())
//        );
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getCardNumber());
        return jwtUtil.generateToken(userDetails);
    }
}
