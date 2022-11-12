package ru.weblab.alfadonate.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonateCreateRequest {
    private Long streamerId;
    private String nickname;
    private String message;
    private String tag;
    private Integer amount;
}
