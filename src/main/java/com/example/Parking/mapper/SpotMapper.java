package com.example.Parking.mapper;

import com.example.Parking.dto.SpotDTO;
import com.example.Parking.model.Spot;
import org.springframework.stereotype.Component;


public class SpotMapper {


    public SpotMapper() {
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
