package com.musclex.msxBackend.service;

import com.musclex.msxBackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.musclex.msxBackend.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Manually fetch a user by username
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    // Manually verify user credentials (used during login)
    public boolean verifyUserCredentials(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Here, you're comparing plain-text passwords (you can change this to hashed passwords)
            return password.equals(user.getPassword());
        }
        return false;
    }

    // Register a new user (can be called from your AuthController during signup)
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

