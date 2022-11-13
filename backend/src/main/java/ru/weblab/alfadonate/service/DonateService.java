package ru.weblab.alfadonate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Donate;
import ru.weblab.alfadonate.exception.NotFoundException;
import ru.weblab.alfadonate.mapper.DonateMapper;
import ru.weblab.alfadonate.repository.DonateRepo;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.responseDto.AnalyticsResponse;
import ru.weblab.alfadonate.responseDto.DonateResponse;
import ru.weblab.alfadonate.responseDto.TopDonaters;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class DonateService {
    private final DonateRepo donateRepo;

    public Mono<Donate> save(DonateCreateRequest request) {
        Donate donate = new Donate();
        donate.setStreamerId(request.getStreamerId());
        donate.setAmount(request.getAmount());
        donate.setDate(Instant.now());
        donate.setMessage(request.getMessage());
        donate.setTag(request.getTag());
        donate.setNickname(request.getNickname());

        return donateRepo.save(donate);
    }

    public Flux<AnalyticsResponse> getAnalytics(String groupBy, Long streamerId) {
        switch (groupBy){
            case "day" -> {
                return donateRepo.getAnalyticsByDay(streamerId);
            }
            case "week" -> {
                return donateRepo.getAnalyticsByWeek(streamerId);
            }
            case "month" -> {
                return donateRepo.getAnalyticsByMonth(streamerId);
            }
        }
        throw new NotFoundException("Group param: " + groupBy + " is not found");
    }

    public Flux<TopDonaters> getTopDonaters() {
        return donateRepo.getTopDonaters();
    }
}
