package ru.weblab.alfadonate.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsResponse {
    @Column("datetime")
    private Instant dateTime;
    @Column("sum")
    private Integer amount;
}
