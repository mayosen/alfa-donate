package ru.weblab.alfadonate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DonateController {
    @GetMapping("/donate/{uuid}")
    public Flux<String> listenForDonates(@PathVariable String uuid) {
        return null;
    }

    @PostMapping("/donate")
    public Mono<?> makeDonate() {
        return null;
    }
}
