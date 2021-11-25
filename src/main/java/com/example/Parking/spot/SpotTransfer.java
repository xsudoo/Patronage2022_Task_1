package com.example.Parking.spot;

import org.springframework.stereotype.Component;

@Component
public class SpotTransfer {


    public SpotTransfer() {
    }

    SpotDTO toDTO(Spot spot) {
        var spotDTO = new SpotDTO();

        spotDTO.setNumber(spot.getNumber());
        spotDTO.setStorey(spot.getStorey());
        spotDTO.setSpotForDisabled(spot.isSpotForDisabled());

        return spotDTO;
    }

    Spot toEntity(SpotDTO spotDTO) {
        var spot = new Spot();

        spot.setNumber(spotDTO.getNumber());
        spot.setStorey(spotDTO.getStorey());
        spot.setSpotForDisabled(spotDTO.isSpotForDisabled());

        return spot;
    }
}
