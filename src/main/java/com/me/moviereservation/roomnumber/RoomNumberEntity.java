package com.me.moviereservation.roomnumber;

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
@Table(schema = "dictionary", name = "room_number")
public class RoomNumberEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room_number_generator")
    @SequenceGenerator(name = "room_number_generator", sequenceName = "room_number_id_seq", allocationSize = 1)
    private Long id;

    private String code;
}
