package ru.weblab.alfadonate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Streamer;
import ru.weblab.alfadonate.repository.StreamerRepo;

import java.util.UUID;

@Service
public class StreamerService {
    private final StreamerRepo streamerRepo;

    @Autowired
    public StreamerService(StreamerRepo streamerRepo) {
        this.streamerRepo = streamerRepo;
    }

    public Mono<Streamer> findById(long id) {
        return streamerRepo.findById(id);
    }

    public Mono<Streamer> findByToken(UUID token) {
        return streamerRepo.findByToken(token);
    }
}
