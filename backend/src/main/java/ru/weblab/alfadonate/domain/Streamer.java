package ru.weblab.alfadonate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "streamer")
public class Streamer {
    @Id
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String description;
    private String iconUrl;
}
