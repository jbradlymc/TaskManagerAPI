package com.example.userservice.service;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (updatedUser.getEmail() != null) {
                user.setEmail(updatedUser.getEmail());
            }

            if (updatedUser.getUsername() != null) {
                user.setUsername(updatedUser.getUsername());
            }

            return userRepository.save(user);

        } else {
            throw new RuntimeException("User does not exist");
        }

    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

}
