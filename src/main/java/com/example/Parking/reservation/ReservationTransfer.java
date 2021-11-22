package com.example.Parking.reservation;

import com.example.Parking.customer.CustomerRepository;
import com.example.Parking.spot.SpotRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationTransfer {

    final private SpotRepository spotRepository;
    final private CustomerRepository customerRepository;


    public ReservationTransfer(SpotRepository spotRepository, CustomerRepository customerRepository) {
        this.spotRepository = spotRepository;
        this.customerRepository = customerRepository;
    }

    ReservationDTO toDTO(Reservation reservation){
        ReservationDTO reservationDTO = new ReservationDTO();

        reservationDTO.setSpotId(reservation.getSpot().getId());
        reservationDTO.setCustomerId(reservation.getCustomer().getId());

        return reservationDTO;
    }

    Reservation toEntity(ReservationDTO reservationDTO){
        Reservation reservation = new Reservation();
        reservation.setSpot(spotRepository.findById(reservationDTO.getSpotId()));
        reservation.setCustomer(customerRepository.findById(reservationDTO.getCustomerId()));
        return reservation;
    }
}
