package com.abcbank.paymenthandling.controller; // Correct package declaration

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import com.abcbank.paymenthandling.LoginController;
import com.abcbank.paymenthandling.User;
import com.abcbank.paymenthandling.UserRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class LoginControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public UserRepository userRepository; // Inject UserRepository

    @InjectMocks
    private LoginController loginController;

    @BeforeEach
    public void setup() {
        User user = new User();
        user.setUsername("testuser");
        user.setPassword("password");
        // userRepository.users.put(user.getUsername(), user); // Access the users map directly
        Mockito.when(userRepository.findByUsername(any())).thenReturn(user);
    }


    @Test
    public void testLogin() throws Exception {
        // Create a login request
        // Map<String, String> loginRequest = new HashMap<>();
        // loginRequest.put("username", "testuser");
        // loginRequest.put("password", "password");

        // Execute login request with request parameters
        mockMvc.perform(post("/api/login")
                        .param("username", "testuser")
                        .param("password", "password"))
                .andExpect(status().isOk()); // Expect 200 OK response
    }
}