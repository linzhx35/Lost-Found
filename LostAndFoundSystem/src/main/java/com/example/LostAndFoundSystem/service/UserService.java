package com.example.LostAndFoundSystem.service;

import com.example.LostAndFoundSystem.entity.User;
import com.example.LostAndFoundSystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service class for User-related operations
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    
    // Create or update a user
    public void saveUser(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("This username is already taken");
        }
        userMapper.insertUser(user);
    }

    // Delete a user by ID
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }

    // Get a user by ID
    public User getUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userMapper.selectAllUsers();
    }
}
