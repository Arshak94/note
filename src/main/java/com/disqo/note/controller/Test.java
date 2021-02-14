package com.disqo.note.controller;

import com.disqo.note.model.User;
import com.disqo.note.model.UserRole;
import com.disqo.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class Test {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public void create(){
        User user = new User();
        user.setUsername("username");
        user.setRole(UserRole.ROLE_ADMIN);
        user.setPassword(passwordEncoder.encode("password"));
        userRepository.save(user);
    }

    @GetMapping("/read")
    public void read(){
        System.out.println("AAAAAAAAAAAAA");
    }
}
