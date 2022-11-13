package ru.weblab.alfadonate.mapper;

import ru.weblab.alfadonate.domain.Streamer;
import ru.weblab.alfadonate.responseDto.StreamerResponse;

public class StreamerMapper {
    public static StreamerResponse fromStreamerToResponse(Streamer streamer) {
        return new StreamerResponse(
                streamer.getId(),
                streamer.getEmail(),
                streamer.getPassword(),
                streamer.getNickname(),
                streamer.getDescription(),
                streamer.getIconUrl()
        );
    }
}
