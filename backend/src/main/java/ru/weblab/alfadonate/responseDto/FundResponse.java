package ru.weblab.alfadonate.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FundResponse {
    private Long id;
    private String name;
    private Integer aim;
    private Integer collected;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
