package ru.weblab.alfadonate.service;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import ru.weblab.alfadonate.mapper.DonateMapper;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.responseDto.DonateResponse;

import java.util.*;

@Service
public class EventService {
    private final Map<UUID, Queue<DonateResponse>> streamers;
    private final DonateService donateService;
    private final StreamerService streamerService;
    private static final ServerSentEvent<DonateResponse> EMPTY_DONATE;

    static {
        EMPTY_DONATE = ServerSentEvent.<DonateResponse> builder()
                .id("")
                .event("no-message")
                .data(null)
                .build();
    }

    public EventService(DonateService donateService, StreamerService userService) {
        this.streamers = new HashMap<>();
        this.streamerService = userService;
        this.donateService = donateService;
    }

    public void addStreamer(UUID token) {
        streamers.put(token, new ArrayDeque<>());
    }

    public ServerSentEvent<DonateResponse> pollDonate(UUID token) {
        DonateResponse donate = streamers.get(token).poll();
        return donate == null
            ? EMPTY_DONATE
            : ServerSentEvent.<DonateResponse> builder()
                .id(String.valueOf(donate.getId()))
                .event("donate")
                .data(donate)
                .build();
    }

    public void pushDonate(DonateCreateRequest request) {
        donateService.save(request).subscribe(donate -> {

            streamerService.findById(request.getStreamerId()).subscribe(streamer -> {
                streamers.get(streamer.getToken()).add(DonateMapper.fromDonateToResponse(donate));
            });

        });
    }
}
