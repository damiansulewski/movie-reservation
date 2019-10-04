package com.me.moviereservation.placenumber;

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
@Table(schema = "dictionary", name = "place_number")
public class PlaceNumberEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "place_number_generator")
    @SequenceGenerator(name = "place_number_generator", sequenceName = "place_number_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
