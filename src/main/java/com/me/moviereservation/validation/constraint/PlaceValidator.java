package com.me.moviereservation.validation.constraint;

import com.me.moviereservation.place.PlaceService;
import com.me.moviereservation.ticket.model.ReserveTicketRequest;
import com.me.moviereservation.validation.ValidPlace;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class PlaceValidator implements ConstraintValidator<ValidPlace, ReserveTicketRequest> {
    private final PlaceService placeService;

    @Override
    public boolean isValid(ReserveTicketRequest value, ConstraintValidatorContext context) {
        return placeService.isPlaceAvailable(value.getMovieUuid(), value.getPlaces());
    }
}
