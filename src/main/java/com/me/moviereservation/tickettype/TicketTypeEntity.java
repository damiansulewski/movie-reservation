package com.me.moviereservation.tickettype;

import com.me.moviereservation.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(schema = "dictionary", name = "ticket_type")
public class TicketTypeEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticket_type_generator")
    @SequenceGenerator(name = "ticket_type_generator", sequenceName = "ticket_type_id_seq", allocationSize = 1)
    private Long id;

    private String code;
    private BigDecimal price;
}
