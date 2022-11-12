package ru.weblab.alfadonate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.mapper.DonateMapper;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.responseDto.DonateResponse;
import ru.weblab.alfadonate.service.EventService;

import java.time.Duration;
import java.time.LocalTime;
import java.util.UUID;

@RestController
public class DonateController {
    private final EventService eventService;

    @Autowired
    public DonateController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/donate/{token}")
    public Flux<ServerSentEvent<DonateResponse>> listenForDonates(@PathVariable UUID token) {
        eventService.addStreamer(token);
        return Flux.interval(Duration.ofSeconds(1))
                .mapNotNull(s -> eventService.pollDonate(token));
    }

    @PostMapping("/donate")
    public void makeDonate(@RequestBody DonateCreateRequest request) {
        eventService.pushDonate(request);
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
