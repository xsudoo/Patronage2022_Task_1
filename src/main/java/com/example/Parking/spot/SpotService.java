package com.example.Parking.spot;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpotService {

    final private SpotRepository spotRepository;
    final private SpotTransfer spotTransfer;

    public SpotService(SpotRepository spotRepository, SpotTransfer spotTransfer) {
        this.spotRepository = spotRepository;
        this.spotTransfer = spotTransfer;
    }

    List<Spot> getAllSpots(){
        return spotRepository.findAll();
    }

    SpotDTO addSpot(SpotDTO spotDTO){
        Spot spot = spotTransfer.toEntity(spotDTO);

       // spotRepository.save(spot);
        return spotTransfer.toDTO(spotRepository.save(spot));
    }

    Spot getById(int id){
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
