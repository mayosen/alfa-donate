package ru.weblab.alfadonate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Fund;
import ru.weblab.alfadonate.repository.FundRepo;
import ru.weblab.alfadonate.requestDto.FundCreateRequest;

import java.time.Instant;

@Service
public class FundService {
    private final FundRepo fundRepo;

    @Autowired
    public FundService(FundRepo fundRepo) {
        this.fundRepo = fundRepo;
    }

    public void create(FundCreateRequest request) {
        fundRepo.findByStreamerId(request.getStreamerId()).subscribe(fund -> {
            if (fund == null) {
                fund = new Fund();
                fund.setStreamerId(request.getStreamerId());
            }

            fund.setName(request.getName());
            fund.setAim(request.getAim());
            fund.setCollected(0);
            fund.setStartDate(Instant.now());
            fund.setEndDate(request.getEndDate());
            fundRepo.save(fund);
        });
    }

    public Mono<Fund> create(Fund fund) {
        return fundRepo.save(fund);
    }

    public Mono<Fund> findByStreamerId(long streamerId) {
        return fundRepo.findByStreamerId(streamerId);
    }
}
