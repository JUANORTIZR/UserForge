package com.onekdev.UserForge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onekdev.UserForge.domain.model.User;
import com.onekdev.UserForge.domain.request.UserRequest;
import com.onekdev.UserForge.domain.response.UserResponse;
import com.onekdev.UserForge.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("users")
public class UserController {
    
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok().body(userService.createUser(userRequest));
    }

    @GetMapping("/by")
    public ResponseEntity<UserResponse> getByID(@RequestParam Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }

    @GetMapping()
    public ResponseEntity<ArrayList<User>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }
    
    @GetMapping("/company")
    public ResponseEntity<List<User>> getMethodName() {
        return ResponseEntity.ok().body(userService.getCompanies());
    }
    

}
