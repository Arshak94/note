package com.disqo.note.service.impl;

import com.disqo.note.binding.UserPayload;
import com.disqo.note.model.User;
import com.disqo.note.model.UserRole;
import com.disqo.note.repository.UserRepository;
import com.disqo.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(UserPayload userPayload) {
        User user = new User();
        user.setUsername(userPayload.getUsername());
        user.setPassword(passwordEncoder.encode(userPayload.getPassword()));
        user.setRole(UserRole.ROLE_USER);
        user.setCreatedDate(LocalDateTime.now());
        user.setLastUpdateTime(LocalDateTime.now());
        return userRepository.save(user);
    }
}
