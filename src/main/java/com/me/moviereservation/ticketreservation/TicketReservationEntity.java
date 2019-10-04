package com.me.moviereservation.ticketreservation;

import com.me.moviereservation.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(name = "ticket_reservation")
public class TicketReservationEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticket_reservation_generator")
    @SequenceGenerator(name = "ticket_reservation_generator", sequenceName = "ticket_reservation_id_seq", allocationSize = 1)
    private Long id;

    private String uuid;
    private String userEmail;
    private BigDecimal totalAmount;

    public TicketReservationEntity(String userEmail) {
        this.uuid = UUID.randomUUID().toString();
        this.userEmail = userEmail;
        this.totalAmount = BigDecimal.ZERO;
    }
}
