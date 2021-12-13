package com.example.Parking.service;

import com.example.Parking.dto.ReservationDTO;
import com.example.Parking.model.Reservation;
import com.example.Parking.repository.CustomerRepository;
import com.example.Parking.repository.ReservationRepository;
import com.example.Parking.repository.SpotRepository;
import com.example.Parking.transfer.ReservationTransfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    final private ReservationRepository reservationRepository;
    final private ReservationTransfer reservationTransfer;
    final private SpotRepository spotRepository;
    final private CustomerRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository, ReservationTransfer reservationTransfer, SpotRepository spotRepository, CustomerRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationTransfer = reservationTransfer;
        this.spotRepository = spotRepository;
        this.customerRepository = customerRepository;
    }


    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        if (reservationRepository.getFirstBySpotId(reservationDTO.getSpotId()) != null) {
            throw new IllegalArgumentException("This spot is taken");
        } else if (spotRepository.findById(reservationDTO.getSpotId()) == null) {
            throw new IllegalArgumentException("There is no such parking spot");
        } else if (customerRepository.findById(reservationDTO.getCustomerId()) == null) {
            throw new IllegalArgumentException("There is no such Customer");
        } else {
            var reservation = reservationTransfer.toEntity(reservationDTO);
            reservationRepository.save(reservation);
            return reservationTransfer.toDTO(reservationRepository.save(reservation));
        }

    }

    public void removeReservation(int id) {
        if (reservationRepository.findById(id) == null) {
            throw new IllegalArgumentException("There is no such reservation");
        } else {
            var res = reservationRepository.findById(id);
            res.getCustomer().deleteReservation(res);
            res.getSpot().deleteReservation();
            reservationRepository.delete(res);
        }
    }


    public List<Reservation> getAllByCustomer(String name) {
        return reservationRepository.findAllByCustomerName(name);
    }
}
