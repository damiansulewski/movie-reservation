package com.me.moviereservation.roomnumber;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomNumberRepository extends JpaRepository<RoomNumberEntity, Long> {
    Optional<RoomNumberEntity> findByCode(String code);
}
