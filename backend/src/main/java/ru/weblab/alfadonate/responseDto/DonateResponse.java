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
public class DonateResponse {
    private Long id;
    private String nickName;
    private String message;
    private String tag;
    private Instant date;
    private Integer amount;
}
