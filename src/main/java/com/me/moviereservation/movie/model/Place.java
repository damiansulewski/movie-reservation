package com.me.moviereservation.movie.model;

import com.me.moviereservation.placenumber.PlaceNumber;
import com.me.moviereservation.placestatus.PlaceStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Place {
    private PlaceNumber placeNumber;
    private PlaceStatus placeStatus;
}
