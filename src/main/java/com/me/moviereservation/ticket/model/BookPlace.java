package com.me.moviereservation.ticket.model;

import com.me.moviereservation.placenumber.PlaceNumber;
import com.me.moviereservation.tickettype.TicketType;
import com.me.moviereservation.validation.ValidName;
import com.me.moviereservation.validation.ValidSurname;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public final class BookPlace {
    @NotNull(message = "{validation.message.required}")
    @Size(min = 3, max = 50, message = "{validation.message.invalid-size}")
    @ValidName
    private String userName;

    @NotNull(message = "{validation.message.required}")
    @Size(min = 3, max = 50, message = "{validation.message.invalid-size}")
    @ValidSurname
    private String userSurname;

    @NotNull(message = "{validation.message.required}")
    private TicketType ticketType;

    @NotNull(message = "{validation.message.required}")
    private PlaceNumber placeNumber;
}
