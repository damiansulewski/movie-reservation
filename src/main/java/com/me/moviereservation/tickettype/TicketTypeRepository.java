package com.me.moviereservation.tickettype;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketTypeRepository extends CrudRepository<TicketTypeEntity, Long> {
    Optional<TicketTypeEntity> findByCode(String code);
}
