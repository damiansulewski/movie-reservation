package com.me.moviereservation.ticketauthorizationtoken;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketReservationAuthorizationTokenRepository extends CrudRepository<TicketReservationAuthorizationTokenEntity, Long> {
    Optional<TicketReservationAuthorizationTokenEntity> findByTicketReservationUuidAndToken(String userUuid, String token);

    Optional<TicketReservationAuthorizationTokenEntity> findByToken(String token);
}
