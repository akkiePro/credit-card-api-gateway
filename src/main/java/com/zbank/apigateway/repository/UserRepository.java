package com.zbank.apigateway.repository;

import com.zbank.apigateway.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCardNumber(String username);
}
