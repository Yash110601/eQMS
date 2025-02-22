package com.example.documentmanagement.service;

import com.example.documentmanagement.model.User;
import com.example.documentmanagement.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(UUID id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
    @Transactional
    public void deleteUserAndRelatedData(UUID userId) {
        // Example: Remove user and associated data in a single transaction
        userRepository.deleteById(userId);
        // relatedRepository.deleteByUserId(userId);
    }

}
