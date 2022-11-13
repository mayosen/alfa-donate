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
                ? null
                : ServerSentEvent.<DonateResponse>builder()
                .id(String.valueOf(donate.getId()))
                .event("donate")
                .data(donate)
                .build();
    }

    public void pushDonate(DonateCreateRequest request) {
        donateService.save(request).subscribe(donate -> {

            streamerService.findById(request.getStreamerId()).subscribe(streamer -> {
                Queue<DonateResponse> queue = streamers.get(streamer.getToken());
                if (queue != null) {
                    queue.add(DonateMapper.fromDonateToResponse(donate));
                }
            });
        });
    }
}
