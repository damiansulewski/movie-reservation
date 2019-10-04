package com.me.moviereservation.movie;

import com.me.moviereservation.movie.model.CreateMovieRequest;
import com.me.moviereservation.movie.model.GetMovieRoomDetailsResponse;
import com.me.moviereservation.movie.model.GetMoviesDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("movies")
public class MovieController {
    private final MovieService movieService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping()
    public void createMovie(@Valid @RequestBody CreateMovieRequest request) {
        movieService.createMovie(request);
    }

    @GetMapping()
    public List<GetMoviesDetailsResponse> getMoviesDetails(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                           @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return movieService.getMoviesDetails(startDate, endDate);
    }

    @GetMapping("{uuid}")
    public GetMovieRoomDetailsResponse getMovieRoomDetails(@PathVariable("uuid") String uuid) {
        return movieService.getMovieRoomDetails(uuid);
    }
}
