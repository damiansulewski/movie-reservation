package com.me.moviereservation.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetMoviesDetailsResponse {
    private String uuid;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long durationMinutes;
}
