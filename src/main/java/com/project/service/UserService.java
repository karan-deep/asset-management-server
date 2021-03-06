package com.project.service;

import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//marking UserService class as an Service
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to find user by their username
    @Override
    public UserDetails loadUserByUsername(String username) {
        com.project.model.User user = userRepository.findByUsername(username);
        if(user!=null){
            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }
        return null;
    }

    // Method to add/register user after encoding the password
    public void addUser(com.project.model.User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
