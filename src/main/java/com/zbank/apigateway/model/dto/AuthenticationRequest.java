package com.zbank.apigateway.model.dto;


import lombok.Data;

@Data
public class AuthenticationRequest {
    private String cardNumber;
    private String pin;
}
