package com.me.moviereservation.ticketauthorizationtoken;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class TicketReservationAuthorizationTokenService {
    private final TicketReservationAuthorizationTokenRepository ticketReservationAuthorizationTokenRepository;

    @Transactional
    public String createTicketAuthorizationToken(String ticketReservationUuid, String userEmail) {
        TicketReservationAuthorizationTokenEntity authorizationToken = new TicketReservationAuthorizationTokenEntity(ticketReservationUuid, userEmail);
        ticketReservationAuthorizationTokenRepository.save(authorizationToken);

        return authorizationToken.getToken();
    }

    public void validToken(String ticketReservationUuid, String token) {
        ticketReservationAuthorizationTokenRepository.findByTicketReservationUuidAndToken(ticketReservationUuid, token)
                .orElseThrow(() ->
                        new RuntimeException(String.format("TicketReservationAuthorizationTokenEntity not found searching by ticketReservationUuid=[%s] and token=[%s]",
                                ticketReservationUuid, token)));
    }

    @Transactional
    public void useToken(String token) {
        TicketReservationAuthorizationTokenEntity authorizationToken = ticketReservationAuthorizationTokenRepository.findByToken(token)
                .orElseThrow(() ->
                        new RuntimeException(String.format("TicketReservationAuthorizationTokenEntity not found searching by token=[%s]",
                                token)));
        authorizationToken.setUsed(Boolean.TRUE);
    }
}
