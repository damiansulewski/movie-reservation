package com.me.moviereservation.ticket;

import com.me.moviereservation.movie.MovieEntity;
import com.me.moviereservation.movie.MovieRepository;
import com.me.moviereservation.place.PlaceEntity;
import com.me.moviereservation.place.PlaceRepository;
import com.me.moviereservation.placenumber.PlaceNumberEntity;
import com.me.moviereservation.placenumber.PlaceNumberRepository;
import com.me.moviereservation.placestatus.PlaceStatus;
import com.me.moviereservation.placestatus.PlaceStatusRepository;
import com.me.moviereservation.ticket.model.ReserveTicketRequest;
import com.me.moviereservation.ticketauthorizationtoken.TicketReservationAuthorizationTokenService;
import com.me.moviereservation.ticketreservation.TicketReservationEntity;
import com.me.moviereservation.ticketreservation.TicketReservationRepository;
import com.me.moviereservation.ticketstatus.TicketStatus;
import com.me.moviereservation.ticketstatus.TicketStatusEntity;
import com.me.moviereservation.ticketstatus.TicketStatusRepository;
import com.me.moviereservation.tickettype.TicketTypeEntity;
import com.me.moviereservation.tickettype.TicketTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final MovieRepository movieRepository;
    private final PlaceRepository placeRepository;
    private final PlaceNumberRepository placeNumberRepository;
    private final TicketTypeRepository ticketTypeRepository;
    private final TicketRepository ticketRepository;
    private final PlaceStatusRepository placeStatusRepository;
    private final TicketReservationAuthorizationTokenService ticketReservationAuthorizationTokenService;
    private final TicketStatusRepository ticketStatusRepository;
    private final TicketReservationRepository ticketReservationRepository;

    @Value("${movie-repository.movie.expiration-minutes:0}")
    private Integer expirationMinutes;

    @Value("${movie-repository.ticket.confirm-reservation-path}")
    private StringBuilder confirmReservationPath;

    @Transactional
    public void reserveTickets(ReserveTicketRequest request) {
        MovieEntity movie = movieRepository.findByUuid(request.getMovieUuid())
                .orElseThrow(() -> new RuntimeException(String.format("MovieEntity not found searching by uuid=[%s]",
                        request.getMovieUuid())));

        TicketReservationEntity ticketReservation = createTicketReservationEntity(request.getUserEmail());

        request.getPlaces().forEach(bookPlace -> {
            TicketEntity ticket = createTicketEntity(
                    bookPlace.getUserName(),
                    bookPlace.getUserSurname(),
                    getTicketExpirationDate(movie.getEndDate()),
                    movie.getEndDate(),
                    ticketTypeRepository.findByCode(bookPlace.getTicketType().toString())
                            .orElseThrow(() -> new RuntimeException(String.format("TicketTypeEntity not found searching by ticketType=[%s]",
                                    bookPlace.getTicketType()))),
                    ticketStatusRepository.findByCode(TicketStatus.RESERVED.toString())
                            .orElseThrow(() -> new RuntimeException(String.format("TicketStatusEntity not found searching by ticketStatus=[%s]",
                                    TicketStatus.RESERVED))),
                    ticketReservation);

            ticketRepository.save(ticket);

            ticketReservation.setTotalAmount(ticketReservation.getTotalAmount().add(ticket.getTicketType().getPrice()));

            PlaceNumberEntity placeNumber = placeNumberRepository.findByCode(bookPlace.getPlaceNumber().toString())
                    .orElseThrow(() -> new RuntimeException(String.format("PlaceNumberEntity not found searching by placeNumber=[%s]",
                            bookPlace.getPlaceNumber())));

            PlaceEntity place = placeRepository.findByRoomAndPlaceNumber(movie.getRoom(), placeNumber)
                    .orElseThrow(() -> new RuntimeException(String.format("PlaceEntity not found searching by roomEntity=[%s] and placeNumberEntity=[%s]",
                            movie.getRoom(), placeNumber)));

            place.setTicket(ticket);
            place.setPlaceStatus(placeStatusRepository.findByCode(PlaceStatus.OCCUPIED.toString())
                    .orElseThrow(() -> new RuntimeException(String.format("PlaceStatus not found searching by code=[%s]",
                            PlaceStatus.OCCUPIED))));

            placeRepository.save(place);
        });

        String ticketAuthorizationToken = ticketReservationAuthorizationTokenService.createTicketAuthorizationToken(ticketReservation.getUuid(), request.getUserEmail());

        sendConfirmationEmail(ticketReservation.getUuid(), ticketAuthorizationToken, request.getUserEmail(), ticketReservation.getTotalAmount(), getTicketExpirationDate(movie.getEndDate()));
    }

    private LocalDateTime getTicketExpirationDate(LocalDateTime endDate) {
        return endDate.minusMinutes(expirationMinutes);
    }

    private TicketReservationEntity createTicketReservationEntity(String userEmail) {
        return new TicketReservationEntity(userEmail);
    }

    private TicketEntity createTicketEntity(String userName, String userSurname,
                                            LocalDateTime expirationDate, LocalDateTime endSessionDate,
                                            TicketTypeEntity ticketType, TicketStatusEntity ticketStatus,
                                            TicketReservationEntity ticketReservation) {
        return new TicketEntity(
                userName,
                userSurname,
                expirationDate,
                endSessionDate,
                ticketType,
                ticketStatus,
                ticketReservation);
    }

    private void sendConfirmationEmail(String ticketReservationUuid, String ticketAuthorizationToken, String userEmail,
                                       BigDecimal totalAmount, LocalDateTime expirationDate) {
        //TODO Send confirmation email
        createConfirmReservationUrl(ticketReservationUuid, ticketAuthorizationToken);
    }

    private String createConfirmReservationUrl(String ticketReservation, String ticketAuthorizationToken) {
        return confirmReservationPath
                .append("?")
                .append("ticketReservationUuid=")
                .append(ticketReservation)
                .append("&")
                .append("tokenUuid=")
                .append(ticketAuthorizationToken)
                .toString();
    }

    @Transactional
    public void confirmReservation(String ticketReservationUuid, String tokenUuid) {
        ticketReservationAuthorizationTokenService.validToken(ticketReservationUuid, tokenUuid);
        ticketReservationAuthorizationTokenService.useToken(tokenUuid);

        TicketStatusEntity ticketStatus = ticketStatusRepository.findByCode(TicketStatus.CONFIRMED.toString())
                .orElseThrow(() -> new RuntimeException(String.format("TicketStatusEntity not found searching by ticketStatus=[%s]",
                        TicketStatus.CONFIRMED)));

        TicketReservationEntity ticketReservation = ticketReservationRepository.findByUuid(ticketReservationUuid)
                .orElseThrow(() -> new RuntimeException(String.format("TicketReservationEntity not found searching by ticketReservationUuid=[%s]",
                        ticketReservationUuid)));

        ticketRepository.findAllByTicketReservation(ticketReservation)
                .forEach(ticket -> ticket.setTicketStatus(ticketStatus));
    }
}
