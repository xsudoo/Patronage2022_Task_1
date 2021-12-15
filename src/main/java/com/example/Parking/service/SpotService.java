package com.example.Parking.service;

import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotService {

    final private SpotRepository spotRepository;

    public SpotService(SpotRepository spotRepository) {
        this.spotRepository = spotRepository;
    }

    public List<Spot> getAllSpots() {
        return spotRepository.findAll();
    }

    public Spot addSpot(Spot spot) {
        if (spotRepository.findByNumberAndStorey(spot.getNumber(), spot.getStorey()) != null) {
            throw new IllegalArgumentException("There is spot with this number and storey");
        } else return spotRepository.save(spot);
    }

    public Spot getById(int id) {
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
