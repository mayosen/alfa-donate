package ru.weblab.alfadonate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Donate;
import ru.weblab.alfadonate.repository.DonateRepo;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;

import java.time.Instant;

@Service
@AllArgsConstructor
public class DonateService {
    private final DonateRepo repo;

    public Mono<Donate> save(DonateCreateRequest request) {
        Donate donate = new Donate();
        donate.setStreamerId(request.getStreamerId());
        donate.setAmount(request.getAmount());
        donate.setDate(Instant.now());
        donate.setMessage(request.getMessage());
        donate.setTag(request.getTag());
        donate.setNickname(request.getNickname());

        return repo.save(donate);
    }
}
