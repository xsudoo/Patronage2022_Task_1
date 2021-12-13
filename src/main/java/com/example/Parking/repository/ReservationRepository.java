package com.example.Parking.repository;

import com.example.Parking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Reservation findById(int id);

    List<Reservation> findAllByCustomerName(String name);

    Object getFirstBySpotId(int id);
}
