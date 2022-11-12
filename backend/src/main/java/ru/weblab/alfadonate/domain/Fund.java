package ru.weblab.alfadonate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fund")
public class Fund {
    @Id
    @Column("fund_id")
    private Long id;

    @Column("streamer_id")
    private Long streamerId;

    @Column("name")
    private String name;

    @Column("aim")
    private Integer aim;

    @Column("collected")
    private Integer collected;

    @Column("start_date")
    private LocalDateTime startDate;

    @Column("end_date")
    private LocalDateTime endDate;
}
