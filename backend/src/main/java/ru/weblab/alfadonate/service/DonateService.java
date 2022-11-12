package ru.weblab.alfadonate.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.weblab.alfadonate.domain.Donate;
import ru.weblab.alfadonate.mapper.DonateMapper;
import ru.weblab.alfadonate.repository.DonateRepo;
import ru.weblab.alfadonate.requestDto.DonateCreateRequest;
import ru.weblab.alfadonate.responseDto.DonateResponse;

@Service
@AllArgsConstructor
public class DonateService {
    private final DonateRepo repo;

    public DonateResponse save(DonateCreateRequest request) {
        Donate donate = new Donate();
        donate.setAmount(request.getAmount());
        donate.setDate(request.getDate());
        donate.setMessage(request.getMessage());
        donate.setRegion(request.getRegion());
        donate.setNickName(request.getNickName());

        return DonateMapper.fromDonateToResponse(repo.save(donate).block());
    }
}
