package ru.weblab.alfadonate.mapper;

import ru.weblab.alfadonate.domain.Donate;
import ru.weblab.alfadonate.responseDto.DonateResponse;

import java.util.List;
import java.util.stream.Collectors;

public class DonateMapper {
    public static DonateResponse fromDonateToResponse(Donate donate) {
        return new DonateResponse(
                donate.getId(),
                donate.getNickName(),
                donate.getMessage(),
                donate.getRegion(),
                donate.getDate(),
                donate.getAmount()
        );
    }

    public static List<DonateResponse> fromDonatesToResponses(List<Donate> donates) {
        return donates.stream()
                .map(DonateMapper::fromDonateToResponse)
                .collect(Collectors.toList());
    }
}
