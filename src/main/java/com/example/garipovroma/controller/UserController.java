package com.example.garipovroma.controller;

import com.example.garipovroma.dto.UserDto;
import com.example.garipovroma.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public interface UserController {
    @PostMapping
    Mono<User> register(@RequestBody UserDto user);
}
