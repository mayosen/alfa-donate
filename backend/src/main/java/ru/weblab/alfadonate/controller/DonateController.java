package ru.weblab.alfadonate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.requestDto.FundCreateRequest;
import ru.weblab.alfadonate.responseDto.AnalyticsResponse;
import ru.weblab.alfadonate.responseDto.DonateResponse;
import ru.weblab.alfadonate.responseDto.FundResponse;
import ru.weblab.alfadonate.responseDto.TopDonaters;
import ru.weblab.alfadonate.service.DonateService;
import ru.weblab.alfadonate.service.DonateStreamingService;
import ru.weblab.alfadonate.service.FundService;
import ru.weblab.alfadonate.service.FundStreamingService;

import javax.validation.Valid;
import java.time.Duration;
import java.util.UUID;

@CrossOrigin(value = "http://localhost:5001", maxAge = 900)
@RestController
public class DonateController {
    private final DonateStreamingService donateStreamingService;
    private final FundStreamingService fundStreamingService;
    private final FundService fundService;
    private final DonateService donateService;

    @Autowired
    public DonateController(
            DonateStreamingService donateStreamingService,
            FundStreamingService fundStreamingService,
            FundService fundService,
            DonateService donateService
    ) {
        this.donateStreamingService = donateStreamingService;
        this.fundStreamingService = fundStreamingService;
        this.fundService = fundService;
        this.donateService = donateService;
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
}
