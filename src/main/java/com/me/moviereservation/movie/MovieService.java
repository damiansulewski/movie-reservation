package com.me.moviereservation.movie;

import com.me.moviereservation.movie.model.CreateMovieRequest;
import com.me.moviereservation.movie.model.GetMovieRoomDetailsResponse;
import com.me.moviereservation.movie.model.GetMoviesDetailsResponse;
import com.me.moviereservation.movie.model.Place;
import com.me.moviereservation.place.PlaceRepository;
import com.me.moviereservation.placenumber.PlaceNumber;
import com.me.moviereservation.placestatus.PlaceStatus;
import com.me.moviereservation.room.RoomEntity;
import com.me.moviereservation.room.RoomRepository;
import com.me.moviereservation.roomnumber.RoomNumber;
import com.me.moviereservation.roomnumber.RoomNumberEntity;
import com.me.moviereservation.roomnumber.RoomNumberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final PlaceRepository placeRepository;
    private final RoomRepository roomRepository;
    private final RoomNumberRepository roomNumberRepository;

    @Transactional
    public void createMovie(CreateMovieRequest request) {
        MovieEntity movie = createMovieEntity(
                request.getName(),
                request.getStartDate(),
                request.getEndDate(),
                getRoomByRoomNumber(request.getRoomNumber()));

        movieRepository.save(movie);
    }

    private RoomEntity getRoomByRoomNumber(RoomNumber roomNumber) {
        RoomNumberEntity roomNumberEntity = roomNumberRepository.findByCode(roomNumber.toString())
                .orElseThrow(() -> new RuntimeException(String.format("RoomNumberEntity not found searching by code=[%s]",
                        roomNumber)));

        return roomRepository.findById(roomNumberEntity.getId())
                .orElseThrow(() -> new RuntimeException(String.format("RoomEntity not found searching by id=[%s]",
                        roomNumberEntity.getId())));
    }

    private MovieEntity createMovieEntity(String name, LocalDateTime startDate, LocalDateTime endDate, RoomEntity room) {
        return new MovieEntity(
                name,
                startDate,
                endDate,
                room);
    }

    public List<GetMoviesDetailsResponse> getMoviesDetails(LocalDateTime startDate, LocalDateTime endDate) {
        List<MovieEntity> movies =
                movieRepository.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqualOrderByStartDate(startDate, endDate);

        return movies.stream()
                .map(movie -> new GetMoviesDetailsResponse(movie.getUuid(), movie.getName(),
                        movie.getStartDate(), movie.getEndDate(),
                        movie.getStartDate().until(movie.getEndDate(), ChronoUnit.MINUTES)))
                .collect(Collectors.toList());
    }

    public GetMovieRoomDetailsResponse getMovieRoomDetails(String uuid) {
        MovieEntity movie = movieRepository.findByUuid(uuid)
                .orElseThrow(() -> new RuntimeException(String.format("MovieEntity not found searching by uuid=[%s]",
                        uuid)));

        return new GetMovieRoomDetailsResponse(
                RoomNumber.valueOf(movie.getRoom().getRoomNumber().getCode()),
                placeRepository.findAllByRoom(movie.getRoom()).stream()
                        .map(room -> Place.builder()
                                .placeNumber(PlaceNumber.valueOf(room.getPlaceNumber().getCode()))
                                .placeStatus(PlaceStatus.valueOf(room.getPlaceStatus().getCode()))
                                .build())
                        .collect(Collectors.toList()));
    }
}
