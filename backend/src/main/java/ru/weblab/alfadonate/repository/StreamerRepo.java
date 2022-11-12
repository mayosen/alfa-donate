package ru.weblab.alfadonate.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.weblab.alfadonate.domain.Streamer;

@Repository
public interface StreamerRepo extends ReactiveCrudRepository<Streamer, Long> {
}
