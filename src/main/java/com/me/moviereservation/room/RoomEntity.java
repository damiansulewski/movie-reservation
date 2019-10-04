package com.me.moviereservation.room;

import com.me.moviereservation.audit.AuditedEntity;
import com.me.moviereservation.roomnumber.RoomNumberEntity;
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
@Table(schema = "dictionary", name = "room")
public class RoomEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "room_generator")
    @SequenceGenerator(name = "room_generator", sequenceName = "room_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private RoomNumberEntity roomNumber;
}
