package ru.weblab.alfadonate.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StreamerResponse {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String description;
    private String iconUrl;
}
