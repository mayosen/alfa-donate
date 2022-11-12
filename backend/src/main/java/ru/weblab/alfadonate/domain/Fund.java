package ru.weblab.alfadonate.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "fund")
public class Fund {
    @Id
    private Long id;
    private String name;
    private Integer aim;
    private Integer collected;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
