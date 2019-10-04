package com.me.moviereservation.ticket;

import com.me.moviereservation.audit.AuditedEntity;
import com.me.moviereservation.ticketreservation.TicketReservationEntity;
import com.me.moviereservation.ticketstatus.TicketStatusEntity;
import com.me.moviereservation.tickettype.TicketTypeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(name = "ticket")
public class TicketEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticket_generator")
    @SequenceGenerator(name = "ticket_generator", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    private String userName;
    private String userSurname;
    private LocalDateTime expirationDate;
    private LocalDateTime endSessionDate;

    @ManyToOne
    private TicketTypeEntity ticketType;

    @ManyToOne
    private TicketStatusEntity ticketStatus;

    @ManyToOne(cascade = CascadeType.ALL)
    private TicketReservationEntity ticketReservation;

    public TicketEntity(String userName, String userSurname,
                        LocalDateTime expirationDate, LocalDateTime endSessionDate,
                        TicketTypeEntity ticketType, TicketStatusEntity ticketStatus,
                        TicketReservationEntity ticketReservation) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.expirationDate = expirationDate;
        this.endSessionDate = endSessionDate;
        this.ticketType = ticketType;
        this.ticketStatus = ticketStatus;
        this.ticketReservation = ticketReservation;
    }
}
