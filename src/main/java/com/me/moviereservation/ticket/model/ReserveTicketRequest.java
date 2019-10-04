package com.me.moviereservation.ticket.model;

import com.me.moviereservation.validation.ValidEmail;
import com.me.moviereservation.validation.ValidPlace;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@ValidPlace
@Getter
@AllArgsConstructor
public final class ReserveTicketRequest {
    @NotNull(message = "{validation.message.required}")
    @Size(min = 36, max = 36, message = "{validation.message.invalid-size}")
    private String movieUuid;

    @NotNull(message = "{validation.message.required}")
    @Size(min = 2, max = 36, message = "{validation.message.invalid-size}")
    @ValidEmail
    private String userEmail;

    @NotNull(message = "{validation.message.required}")
    @Valid
    private List<BookPlace> places;
}
