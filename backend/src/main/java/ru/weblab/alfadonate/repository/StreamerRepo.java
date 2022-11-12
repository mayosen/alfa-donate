package ru.weblab.alfadonate.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Streamer;

import java.util.UUID;

@Repository
public interface StreamerRepo extends ReactiveCrudRepository<Streamer, Long> {
    Mono<Streamer> findByToken(UUID token);
}
