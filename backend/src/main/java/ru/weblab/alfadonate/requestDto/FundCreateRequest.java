package ru.weblab.alfadonate.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FundCreateRequest {
    @NotNull
    private Long streamerId;

    @NotBlank
    private String name;

    @NotNull
    private Integer aim;

    @NotNull
    private Instant endDate;
}
