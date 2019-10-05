package com.me.moviereservation.ticket;

import com.me.moviereservation.ticket.model.ReserveTicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping("tickets")
public class TicketController {
    private final TicketService ticketService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void reserveTickets(@Valid @RequestBody ReserveTicketRequest request) {
        ticketService.reserveTickets(request);
    }

    @GetMapping("confirm")
    public void confirmReservation(@NotNull @RequestParam("ticketReservationUuid") String ticketReservationUuid, @NotNull @RequestParam("tokenUuid") String tokenUuid) {
        ticketService.confirmReservation(ticketReservationUuid, tokenUuid);
    }
}
