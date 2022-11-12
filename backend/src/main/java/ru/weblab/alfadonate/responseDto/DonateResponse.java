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
public class DonateResponse {
    private Long id;
    private String nickName;
    private String message;
    private String region;
    private LocalDateTime date;
    private Integer amount;
}
