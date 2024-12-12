package com.abcbank.paymenthandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistration {

    @Autowired

    private UserRepository userRepository;

    @PostMapping("/api/register")
    public ResponseEntity<Boolean> register(@RequestBody User user) {
        Boolean userSaved = userRepository.saveUser(user);
        if (userSaved) {
        return ResponseEntity.ok(userSaved);
        } else {
            return ResponseEntity.badRequest().body(userSaved);
        }
    }
    
}
