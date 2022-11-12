package ru.weblab.alfadonate.controller;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;

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

    @GetMapping("/stream-sse/{id}")
    public Flux<ServerSentEvent<String>> streamEvents(@PathVariable Long id) {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String> builder()
                        .id(String.valueOf(sequence))
                        .event("periodic-event")
                        .data("SSE - " + LocalTime.now().toString())
                        .build());
    }
}
