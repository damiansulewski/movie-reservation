package com.me.moviereservation.movie.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class GetMoviesDetailsResponse {
    private String uuid;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long durationMinutes;
}
