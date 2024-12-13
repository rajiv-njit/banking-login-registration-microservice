package com.abcbank.paymenthandling;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    public Map<String, User> users = new HashMap<>();

    // Add this method to initialize a test user
    @PostConstruct 
    public void init() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        users.put(user.getUsername(), user);
    }

    public User findByUsername(String username) {
        // In a real application, you would fetch this from a database
        return users.get(username); 
    }

    public boolean saveUser(User user){
        System.out.println("User is saved");
        return(true);
    }

}
