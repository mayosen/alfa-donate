package ru.weblab.alfadonate.domain;

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
@Table(name = "donate")
public class Donate {
    @Id
    private Long id;
    private String nickName;
    private String message;
    private String region;
    private LocalDateTime date;
    private Integer amount;
}
