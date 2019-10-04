package com.me.moviereservation.ticketauthorizationtoken;

import com.me.moviereservation.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ticket_reservation_authorization_token")
public class TicketReservationAuthorizationTokenEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_reservation_authorization_token_generator")
    @SequenceGenerator(name = "ticket_reservation_authorization_token_generator", sequenceName = "ticket_reservation_authorization_token_id_seq", allocationSize = 1)
    private Long id;

    private String ticketReservationUuid;
    private String userEmail;
    private String token;
    private boolean used;

    TicketReservationAuthorizationTokenEntity(String ticketReservationUuid, String userEmail) {
        this.ticketReservationUuid = ticketReservationUuid;
        this.userEmail = userEmail;
        this.token = UUID.randomUUID().toString();
    }
}
