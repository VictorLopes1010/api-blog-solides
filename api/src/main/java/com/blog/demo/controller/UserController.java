package com.blog.demo.controller;


import com.blog.demo.dto.RegisterDTO;
import com.blog.demo.dto.UserDTO;
import com.blog.demo.model.User;
import com.blog.demo.repository.UserRepository;
import com.blog.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO registerDTO){
        if(this.userRepository.findByEmail(registerDTO.email()) != null) return  ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        User newUser = new User(registerDTO.email(), registerDTO.name(), encryptedPassword);

        this.userRepository.saveAndFlush(newUser);

        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> searchListUsers(){
        return ResponseEntity.ok(userService.searchListUsers());
    }
}
