package com.abcbank.paymenthandling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Boolean userSaved = userRepository.saveUser(user);
        if (userSaved) {
            return ResponseEntity.ok("Registration successful!");
        } else {
            return ResponseEntity.badRequest().body("Registration failed!"); 
        }
    }
}
