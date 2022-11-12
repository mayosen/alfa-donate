package ru.weblab.alfadonate.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "streamer")
public class Streamer {
    @Id
    @Column("streamer_id")
    private Long id;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("nickname")
    private String nickname;

    @Column("description")
    private String description;

    @Column("icon_url")
    private String iconUrl;

    @Column("token")
    private UUID token;
}
