package ru.weblab.alfadonate.mapper;

import ru.weblab.alfadonate.domain.Fund;
import ru.weblab.alfadonate.responseDto.FundResponse;

public class FundMapper {
    public static FundResponse fromFundToResponse(Fund fund) {
        return new FundResponse(
                fund.getId(),
                fund.getName(),
                fund.getAim(),
                fund.getCollected(),
                fund.getStartDate(),
                fund.getEndDate()
        );
    }
}
