package com.me.moviereservation.place;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceSchedulingService {
    private final PlaceService placeService;

    @Scheduled(cron = "${movie-repository.place.clear-expired-tickets-cron}")
    public void clearExpiredTickets() {
        placeService.clearExpiredTickets();
    }
}
