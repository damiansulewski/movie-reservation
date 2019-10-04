package com.me.moviereservation.movie.model;

import com.me.moviereservation.roomnumber.RoomNumber;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetMovieRoomDetailsResponse {
    private RoomNumber roomNumber;
    private List<Place> places;
}
