package com.example.Parking.reservation;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    final private ReservationRepository reservationRepository;
    final private ReservationTransfer reservationTransfer;

    public ReservationService(ReservationRepository reservationRepository, ReservationTransfer reservationTransfer) {
        this.reservationRepository = reservationRepository;
        this.reservationTransfer = reservationTransfer;
    }


    public List<Reservation> getAllReservation() {
        System.out.println("weszlo");
        return reservationRepository.findAll();
    }

    public ReservationDTO addReservation(ReservationDTO reservationDTO) {
        if(reservationRepository.getFirstBySpotId(reservationDTO.getSpotId()) != null){
            throw new IllegalArgumentException("This spot is taken");
        }else {
            var reservation = reservationTransfer.toEntity(reservationDTO);
            reservationRepository.save(reservation);
            return reservationTransfer.toDTO(reservationRepository.save(reservation));
        }

    }

    void removeReservation(int id) {
        var res = reservationRepository.findById(id);
        res.getCustomer().deleteReservation(res);
        res.getSpot().deleteReservation();
        reservationRepository.delete(res);
    }


    public List<Reservation> getAllByCustomer(String name) {
        return reservationRepository.findAllByCustomerName(name);
    }
}
