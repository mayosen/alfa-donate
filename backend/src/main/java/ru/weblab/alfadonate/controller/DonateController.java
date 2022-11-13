package ru.weblab.alfadonate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Streamer;
import ru.weblab.alfadonate.mapper.StreamerMapper;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.requestDto.FundCreateRequest;
import ru.weblab.alfadonate.responseDto.*;
import ru.weblab.alfadonate.service.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.UUID;

@RestController
public class DonateController {
    private final DonateStreamingService donateStreamingService;
    private final FundStreamingService fundStreamingService;
    private final FundService fundService;
    private final DonateService donateService;
    private final StreamerService streamerService;

    @Autowired
    public DonateController(
            DonateStreamingService donateStreamingService,
            FundStreamingService fundStreamingService,
            FundService fundService,
            DonateService donateService,
            StreamerService streamerService) {
        this.donateStreamingService = donateStreamingService;
        this.fundStreamingService = fundStreamingService;
        this.fundService = fundService;
        this.donateService = donateService;
        this.streamerService = streamerService;
    }

    @PostMapping("/donate")
    public void makeDonate(@Valid @RequestBody DonateCreateRequest request) {
        donateStreamingService.pushDonate(request);
    }

    @GetMapping("/donate/{token}")
    public Flux<ServerSentEvent<DonateResponse>> listenForDonates(@PathVariable UUID token) {
        donateStreamingService.addStreamer(token);
        return Flux.interval(Duration.ofSeconds(1))
                .mapNotNull(s -> donateStreamingService.pollDonate(token));
    }

    @PostMapping("/fund")
    public void startFund(@Valid @RequestBody FundCreateRequest request) {
        fundService.create(request);
    }

    @DeleteMapping("/fund/{token}")
    public void dropFund(@PathVariable UUID token) {
        fundService.drop(token);
    }

    @GetMapping("/fund/{token}")
    public Flux<ServerSentEvent<FundResponse>> listenForFund(@PathVariable UUID token) {
        fundStreamingService.addStreamer(token);
        return Flux.interval(Duration.ofSeconds(1))
                .mapNotNull(s -> fundStreamingService.pollFundUpdate(token));
    }

    @GetMapping("/analytics/top-donaters")
    public Flux<TopDonaters> getAnalytics() {
        return donateService.getTopDonaters();
    }

    @GetMapping("/analytics/by-date/{streamerId}")
    public Flux<AnalyticsResponse> getAnalytics(@PathVariable Long streamerId, @RequestParam String groupBy) {
        return donateService.getAnalytics(groupBy, streamerId);
    }

    @GetMapping("streamer/{streamerId}")
    public Mono<Streamer> getById(@PathVariable Long streamerId) {
        return streamerService.findById(streamerId);
    }
}
