package com.me.moviereservation.ticket;

import com.me.moviereservation.ticketreservation.TicketReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<TicketEntity, Long> {
    List<TicketEntity> findAllByTicketReservation(TicketReservationEntity ticketReservation);
}
