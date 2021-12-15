package com.example.Parking.repository;

import com.example.Parking.model.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Integer> {

    Spot findById(int id);

    List<Spot> getAllByReservationCustomerName(String name);


    Spot findByNumberAndStorey (int number, int storey);

}
