package com.example.Parking.spot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpotService {

    final private SpotRepository spotRepository;

    public SpotService(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    List<Spot> getAllSpots(){
        return spotRepository.findAll();
    }

    Spot addSpot(Spot spot){
        return spotRepository.save(spot);
    }
}
