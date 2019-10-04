package com.me.moviereservation.placenumber;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceNumberRepository extends JpaRepository<PlaceNumberEntity, Long> {
    Optional<PlaceNumberEntity> findByCode(String code);
}
