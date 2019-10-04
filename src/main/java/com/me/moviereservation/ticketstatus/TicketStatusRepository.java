package com.me.moviereservation.ticketstatus;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketStatusRepository extends CrudRepository<TicketStatusEntity, Long> {
    Optional<TicketStatusEntity> findByCode(String code);
}
