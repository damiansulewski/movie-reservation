package com.me.moviereservation.place;

import com.me.moviereservation.audit.AuditedEntity;
import com.me.moviereservation.placenumber.PlaceNumberEntity;
import com.me.moviereservation.placestatus.PlaceStatusEntity;
import com.me.moviereservation.room.RoomEntity;
import com.me.moviereservation.ticket.TicketEntity;
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
@Table(schema = "dictionary", name = "place")
public class PlaceEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "place_generator")
    @SequenceGenerator(name = "place_generator", sequenceName = "place_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    private RoomEntity room;

    @ManyToOne
    private PlaceNumberEntity placeNumber;

    @ManyToOne
    private PlaceStatusEntity placeStatus;

    @ManyToOne
    private TicketEntity ticket;
}
