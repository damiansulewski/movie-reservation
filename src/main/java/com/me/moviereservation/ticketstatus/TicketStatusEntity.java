package com.me.moviereservation.ticketstatus;

import com.me.moviereservation.audit.AuditedEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(schema = "dictionary", name = "ticket_status")
public class TicketStatusEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticket_status_generator")
    @SequenceGenerator(name = "ticket_status_generator", sequenceName = "ticket_status_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
