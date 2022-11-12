package ru.weblab.alfadonate.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import ru.weblab.alfadonate.domain.Fund;

@Repository
public interface FundRepo extends ReactiveCrudRepository<Fund, Long> {
    Mono<Fund> findByStreamerId(long streamerId);
}
