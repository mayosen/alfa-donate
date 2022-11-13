package ru.weblab.alfadonate.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.weblab.alfadonate.domain.Donate;
import ru.weblab.alfadonate.responseDto.AnalyticsResponse;
import ru.weblab.alfadonate.responseDto.TopDonaters;

import java.util.List;

@Repository
public interface DonateRepo extends ReactiveCrudRepository<Donate, Long> {
    @Query(value = "SELECT date_trunc('day', date) dateTime, sum(amount) " +
            "FROM donate " +
            "WHERE streamer_id = :streamerId " +
            "GROUP BY dateTime")
    Flux<AnalyticsResponse> getAnalyticsByDay(Long streamerId);

    @Query(value = "SELECT date_trunc('week', date) dateTime, sum(amount)" +
            "FROM donate " +
            "WHERE streamer_id = :streamerId " +
            "GROUP BY dateTime")
    Flux<AnalyticsResponse> getAnalyticsByWeek(Long streamerId);

    @Query(value = "SELECT date_trunc('month', date) dateTime, sum(amount) " +
            "FROM donate " +
            "WHERE streamer_id = :streamerId " +
            "GROUP BY dateTime")
    Flux<AnalyticsResponse> getAnalyticsByMonth(Long streamerId);

    @Query("SELECT nickname,  SUM(amount) " +
            "FROM donate " +
            "GROUP BY nickname " +
            "ORDER BY SUM(amount) DESC " +
            "LIMIT 10")
    Flux<TopDonaters> getTopDonaters();

}
