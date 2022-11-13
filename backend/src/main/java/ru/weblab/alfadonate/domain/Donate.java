package ru.weblab.alfadonate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "donate")
public class Donate {
    @Id
    @Column("donate_id")
    private Long id;

    @Column("streamer_id")
    private Long streamerId;

    @Column("nickname")
    private String nickname;

    @Column("message")
    private String message;

    @Column("tag")
    private String tag;

    @Column("date")
    private Instant date;

    @Column("amount")
    private Integer amount;
}
