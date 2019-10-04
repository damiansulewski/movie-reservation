package com.me.moviereservation.placestatus;

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
@Table(schema = "dictionary", name = "place_status")
public class PlaceStatusEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "place_status_generator")
    @SequenceGenerator(name = "place_status_generator", sequenceName = "place_status_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
