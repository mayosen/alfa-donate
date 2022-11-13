package ru.weblab.alfadonate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.responseDto.AnalyticsResponse;
import ru.weblab.alfadonate.responseDto.DonateResponse;
import ru.weblab.alfadonate.responseDto.TopDonaters;
import ru.weblab.alfadonate.service.DonateService;
import ru.weblab.alfadonate.service.EventService;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@RestController
public class DonateController {
    private final EventService eventService;
    private final DonateService donateService;

    @Autowired
    public DonateController(EventService eventService, DonateService donateService) {
        this.eventService = eventService;
        this.donateService = donateService;
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

    @GetMapping("/analytics/by-date/{streamerId}")
    public Flux<AnalyticsResponse> getAnalytics(@PathVariable Long streamerId, @RequestParam String groupBy) {
        return donateService.getAnalytics(groupBy, streamerId);
    }

    @GetMapping("/analytics/top-donaters")
    public Flux<TopDonaters> getAnalytics() {
        return donateService.getTopDonaters();
    }
}
