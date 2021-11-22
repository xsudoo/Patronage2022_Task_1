package com.example.Parking.spot;

import com.example.Parking.reservation.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class SpotTransfer {

    final private ReservationRepository reservationRepository;

    public SpotTransfer(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    SpotDTO toDTO(Spot spot) {
        SpotDTO spotDTO = new SpotDTO();

        spotDTO.setNumber(spot.getNumber());
        spotDTO.setStorey(spot.getStorey());
        spotDTO.setSpotForDisabled(spot.isSpotForDisabled());

        return spotDTO;
    }

    Spot toEntity(SpotDTO spotDTO) {
        Spot spot = new Spot();

        spot.setNumber(spotDTO.getNumber());
        spot.setStorey(spotDTO.getStorey());
        spot.setSpotForDisabled(spotDTO.isSpotForDisabled());

        return spot;
    }
}
