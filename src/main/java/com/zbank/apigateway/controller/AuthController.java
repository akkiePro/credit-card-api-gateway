package com.zbank.apigateway.controller;

import com.zbank.apigateway.model.User;
import com.zbank.apigateway.model.dto.AuthenticationRequest;
import com.zbank.apigateway.model.dto.AuthenticationResponse;
import com.zbank.apigateway.service.JwtService;
import com.zbank.apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private JwtService jwtService;
    @Autowired private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) throws Exception {
        String jwt = jwtService.createJwtToken(request);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        if (userService.findByUsername(user.getCardNumber()) != null) {
            return ResponseEntity.badRequest().body("Username is already taken.");
        }
        userService.save(user);
        return ResponseEntity.ok("User registered successfully.");
    }
}
