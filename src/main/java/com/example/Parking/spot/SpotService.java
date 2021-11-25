package com.example.Parking.spot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotService {

    final private SpotRepository spotRepository;

    public SpotService(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    Spot addSpot(Spot spot) {
        if(spotRepository.findByNumberAndStorey(spot.getNumber(), spot.getStorey()) != null ){
            System.out.println(spot.getReservation());
            throw new IllegalArgumentException("There is spot with this number and storey");
        }else return spotRepository.save(spot);
    }

    Spot getById(int id) {
        return spotRepository.findById(id);
    }

    public List<Spot> getAllSpotsByCustomer(String name) {
        return spotRepository.getAllByReservationCustomerName(name);
    }

    public List<Spot> getAllFreeSpots() {
        return spotRepository.findAll().stream()
                .filter(spot -> spot.getReservation() == null)
                .collect(Collectors.toList());
    }
}
