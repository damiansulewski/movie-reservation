package com.me.moviereservation.place;

import com.me.moviereservation.movie.MovieEntity;
import com.me.moviereservation.movie.MovieRepository;
import com.me.moviereservation.placenumber.PlaceNumberEntity;
import com.me.moviereservation.placenumber.PlaceNumberRepository;
import com.me.moviereservation.placestatus.PlaceStatus;
import com.me.moviereservation.placestatus.PlaceStatusEntity;
import com.me.moviereservation.placestatus.PlaceStatusRepository;
import com.me.moviereservation.ticket.model.BookPlace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {
    private final PlaceRepository placeRepository;
    private final PlaceStatusRepository placeStatusRepository;
    private final MovieRepository movieRepository;
    private final PlaceNumberRepository placeNumberRepository;

    @Value("${movie-repository.movie.expiration-minutes:0}")
    private Integer expirationMinutes;

    public void clearExpiredTickets() {
        List<PlaceEntity> places = placeRepository.findAll();

        PlaceStatusEntity placeStatus = placeStatusRepository.findByCode(PlaceStatus.FREE.toString())
                .orElseThrow(() -> new RuntimeException(String.format("PlaceStatusEntity not found searching by code=[%s]",
                        PlaceStatus.FREE)));

        places.stream()
                .filter(place ->
                        PlaceStatus.OCCUPIED.toString().equals(place.getPlaceStatus().getCode()) &&
                                LocalDateTime.now().isAfter(place.getTicket().getEndSessionDate()))
                .forEach(place -> {
                    place.setPlaceStatus(placeStatus);
                    place.setTicket(null);
                    placeRepository.save(place);
                });
    }

    public boolean isPlaceAvailable(String movieUuid, List<BookPlace> bookPlaces) {
        MovieEntity movie = movieRepository.findByUuid(movieUuid)
                .orElseThrow(() -> new RuntimeException(String.format("MovieEntity not found searching by uuid=[%s]",
                        movieUuid)));

        if (!isBeforeExpirationDate(movie)) return false;
        if (!isPlacesInOneRow(bookPlaces)) return false;
        if (!isPlacesNextToEachOther(bookPlaces)) return false;
        return isPlacesInOccupiedStatus(bookPlaces, movie);
    }

    private boolean isBeforeExpirationDate(MovieEntity movie) {
        return LocalDateTime.now().isBefore(movie.getEndDate().minusMinutes(expirationMinutes));
    }

    private boolean isPlacesInOneRow(List<BookPlace> bookPlaces) {
        List<String> placeCharacters = new ArrayList<>();

        bookPlaces.forEach(bookPlace -> {
            String tmpPlaceNumber = bookPlace.getPlaceNumber().toString();
            placeCharacters.add((tmpPlaceNumber.replaceAll("\\d+", "")));
        });

        return placeCharacters.stream().allMatch(placeCharacters.get(0)::equals);
    }

    private boolean isPlacesNextToEachOther(List<BookPlace> bookPlaces) {
        List<Integer> placeDigits = new ArrayList<>();
        List<Integer> sortedPlaceDigits;

        bookPlaces.forEach(bookPlace -> {
            String tmpPlaceNumber = bookPlace.getPlaceNumber().toString();
            placeDigits.add(Integer.parseInt(tmpPlaceNumber.replaceAll("\\D+", "")));
        });

        sortedPlaceDigits = placeDigits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        for (int i = 0; i < sortedPlaceDigits.size() - 1; i++) {
            if (!sortedPlaceDigits.get(i).equals(sortedPlaceDigits.get(i + 1) - 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isPlacesInOccupiedStatus(List<BookPlace> bookPlaces, MovieEntity movie) {
        return bookPlaces.stream().noneMatch(bookPlace -> {
            PlaceNumberEntity placeNumber = placeNumberRepository.findByCode(bookPlace.getPlaceNumber().toString())
                    .orElseThrow(() -> new RuntimeException(String.format("PlaceNumberEntity not found searching by placeNumber=[%s]",
                            bookPlace.getPlaceNumber())));

            return PlaceStatus.OCCUPIED.toString().equals(
                    placeRepository.findByRoomAndPlaceNumber(movie.getRoom(), placeNumber)
                            .orElseThrow(() -> new RuntimeException(String.format("PlaceEntity not found searching by roomEntity=[%s] and placeNumberEntity=[%s]",
                                    movie.getRoom(), placeNumber))).getPlaceStatus().getCode());
        });
    }
}
