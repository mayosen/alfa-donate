package ru.weblab.alfadonate.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import ru.weblab.alfadonate.domain.Donate;

@Repository
public interface DonateRepo extends ReactiveCrudRepository<Donate, Long> {
}
