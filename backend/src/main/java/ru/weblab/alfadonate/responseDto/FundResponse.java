package ru.weblab.alfadonate.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundResponse {
    private Long id;
    private String name;
    private Integer aim;
    private Integer collected;
    private Instant startDate;
    private Instant endDate;
}
