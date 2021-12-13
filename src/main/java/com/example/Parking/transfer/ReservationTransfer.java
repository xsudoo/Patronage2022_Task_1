package com.example.Parking.transfer;

import com.example.Parking.dto.ReservationDTO;
import com.example.Parking.model.Reservation;
import com.example.Parking.repository.CustomerRepository;
import com.example.Parking.repository.SpotRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationTransfer {

    final private SpotRepository spotRepository;
    final private CustomerRepository customerRepository;


    public ReservationTransfer(SpotRepository spotRepository, CustomerRepository customerRepository) {
        this.spotRepository = spotRepository;
        this.customerRepository = customerRepository;
    }

    public ReservationDTO toDTO(Reservation reservation) {
        var reservationDTO = new ReservationDTO();

        reservationDTO.setSpotId(reservation.getSpot().getId());
        reservationDTO.setCustomerId(reservation.getCustomer().getId());

        return reservationDTO;
    }

    public Reservation toEntity(ReservationDTO reservationDTO) {
        var reservation = new Reservation();
        reservation.setSpot(spotRepository.findById(reservationDTO.getSpotId()));
        reservation.setCustomer(customerRepository.findById(reservationDTO.getCustomerId()));
        return reservation;
    }
}
