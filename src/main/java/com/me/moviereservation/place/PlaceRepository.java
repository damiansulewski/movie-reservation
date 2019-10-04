package com.me.moviereservation.place;

import com.me.moviereservation.placenumber.PlaceNumberEntity;
import com.me.moviereservation.room.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository extends JpaRepository<PlaceEntity, Long> {
    List<PlaceEntity> findAllByRoom(RoomEntity room);

    Optional<PlaceEntity> findByRoomAndPlaceNumber(RoomEntity room, PlaceNumberEntity placeNumber);
}
