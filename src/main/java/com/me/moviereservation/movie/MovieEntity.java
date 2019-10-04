package com.me.moviereservation.movie;

import com.me.moviereservation.audit.AuditedEntity;
import com.me.moviereservation.room.RoomEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Audited
@Entity
@NoArgsConstructor
@Table(name = "movie")
public class MovieEntity extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "movie_generator")
    @SequenceGenerator(name = "movie_generator", sequenceName = "movie_id_seq", allocationSize = 1)
    private Long id;

    private String uuid;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToOne
    private RoomEntity room;

    public MovieEntity(String name, LocalDateTime startDate, LocalDateTime endDate, RoomEntity room) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }
}
