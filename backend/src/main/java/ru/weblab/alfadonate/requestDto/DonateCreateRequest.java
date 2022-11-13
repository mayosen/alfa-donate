package ru.weblab.alfadonate.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonateCreateRequest {
    @NotNull
    private Long streamerId;

    @NotBlank
    private String nickname;

    private String message;

    private String tag;

    @NotNull
    private Integer amount;
}
