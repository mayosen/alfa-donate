package ru.weblab.alfadonate.service;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import ru.weblab.alfadonate.mapper.FundMapper;
import ru.weblab.alfadonate.responseDto.FundResponse;

import java.util.*;

@Service
public class FundStreamingService {
    private final Map<UUID, Queue<FundResponse>> streamers;
    private final FundService fundService;

    public FundStreamingService(FundService fundService) {
        this.fundService = fundService;
        this.streamers = new HashMap<>();
    }

    public void addStreamer(UUID token) {
        streamers.put(token, new ArrayDeque<>());
    }

    public ServerSentEvent<FundResponse> pollFundUpdate(UUID token) {
        FundResponse fund = streamers.get(token).poll();
        if (fund == null) {
            return null;
        } else {
            return ServerSentEvent.<FundResponse>builder()
                    .id(String.valueOf(fund.getId()))
                    .event("fund-update")
                    .data(fund)
                    .build();
        }
    }

    public void pushFundUpdate(long streamerId, UUID token, int amount) {
        fundService.findByStreamerId(streamerId).subscribe(fund -> {
            if (fund == null) {
                return;
            }
            fund.setCollected(fund.getCollected() + amount);
            fundService.update(fund).subscribe(f -> {
                Queue<FundResponse> queue = streamers.get(token);
                if (queue != null) {
                    queue.add(FundMapper.fromFundToResponse(f));
                }
            });
        });
    }
}
