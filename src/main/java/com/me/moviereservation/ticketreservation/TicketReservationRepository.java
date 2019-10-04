package com.me.moviereservation.ticketreservation;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketReservationRepository extends CrudRepository<TicketReservationEntity, Long> {
    Optional<TicketReservationEntity> findByUuid(String uuid);
}
