package com.me.moviereservation.movie.model;

import com.me.moviereservation.roomnumber.RoomNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public final class CreateMovieRequest {
    @NotNull(message = "{validation.message.required}")
    @Size(min = 2, max = 50, message = "{validation.message.invalid-size}")
    private String name;

    @NotNull(message = "{validation.message.required}")
    private RoomNumber roomNumber;

    @NotNull(message = "{validation.message.required}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startDate;

    @NotNull(message = "{validation.message.required}")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime endDate;

    @AssertTrue(message = "{validation.message.invalid-movie-date}")
    private boolean isStartDateBeforeEndDateValid() {
        return this.startDate.isBefore(this.endDate);
    }
}
