package com.onekdev.UserForge.service;

import org.springframework.stereotype.Service;

import com.onekdev.UserForge.domain.model.User;
import com.onekdev.UserForge.domain.request.UserRequest;
import com.onekdev.UserForge.domain.response.UserResponse;
import com.onekdev.UserForge.repository.UserRepository;

@Service
public class UserService {
    

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(UserRequest userRequest) {

        User user = new User(userRequest);

        try {
            return new UserResponse(userRepository.save(user));
        } catch (Exception e) {
            throw e;
        }
        
    }

    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        return new UserResponse(user);
    }


}
