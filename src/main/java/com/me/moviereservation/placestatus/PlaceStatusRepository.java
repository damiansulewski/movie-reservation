package com.me.moviereservation.placestatus;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlaceStatusRepository extends CrudRepository<PlaceStatusEntity, Long> {
    Optional<PlaceStatusEntity> findByCode(String code);
}
