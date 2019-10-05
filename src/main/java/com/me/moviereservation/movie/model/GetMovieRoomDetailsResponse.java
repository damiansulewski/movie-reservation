package com.me.moviereservation.movie.model;

import com.me.moviereservation.roomnumber.RoomNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetMovieRoomDetailsResponse {
    private RoomNumber roomNumber;
    private List<Place> places;
}
