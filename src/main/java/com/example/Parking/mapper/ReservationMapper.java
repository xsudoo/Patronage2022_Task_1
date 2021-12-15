package com.example.Parking.mapper;

import com.example.Parking.dto.ReservationDTO;
import com.example.Parking.model.Reservation;


public class ReservationMapper {


    public static ReservationDTO toDTO(Reservation reservation) {
        var reservationDTO = new ReservationDTO();

        reservationDTO.setSpotId(reservation.getSpot().getId());
        reservationDTO.setCustomerId(reservation.getCustomer().getId());

        return reservationDTO;
    }

    public static Reservation toEntity(ReservationDTO reservationDTO) {
        return new Reservation();
    }
}
