package com.zbank.apigateway.service;

import com.zbank.apigateway.model.User;
import com.zbank.apigateway.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;

    public User save(User user) {
        user.setPin(passwordEncoder.encode(user.getPin()));
        return userRepository.save(user);
    }
    public User findByUsername(String username) { return userRepository.findByCardNumber(username); }
}
