package ru.weblab.alfadonate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin(value = "http://localhost:5001", maxAge = 900)
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
