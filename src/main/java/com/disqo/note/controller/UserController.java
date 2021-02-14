package com.disqo.note.controller;

import com.disqo.note.binding.UserPayload;
import com.disqo.note.model.User;
import com.disqo.note.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User create(@Valid @RequestBody UserPayload userPayload){
        return userService.create(userPayload);
    }
}
