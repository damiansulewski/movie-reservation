package com.me.moviereservation.movie;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<MovieEntity, Long> {
    List<MovieEntity> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByStartDate(LocalDateTime startDate, LocalDateTime endDate);

    Optional<MovieEntity> findByUuid(String uuid);
}
