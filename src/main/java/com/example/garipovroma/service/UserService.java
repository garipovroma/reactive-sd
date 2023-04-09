package com.example.garipovroma.service;

import com.example.garipovroma.controller.UserController;
import com.example.garipovroma.dto.UserDto;
import com.example.garipovroma.model.User;
import com.example.garipovroma.repository.UserRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService implements UserController {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public Mono<User> register(UserDto user) {
        User.CurrencyType type;
        try {
            type = User.CurrencyType.valueOf(user.getCurrencyType());
        } catch (IllegalArgumentException e) {
            return Mono.error(() -> e);
        }

        return userRepository.save(new User(user.getName(), type));
    }
}
