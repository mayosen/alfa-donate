package ru.weblab.alfadonate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class AuthController {
    @PostMapping("/register")
    public Mono<?> register() {
        return null;
    }

    @PostMapping("/login")
    public Mono<?> login() {
        return null;
    }

}
