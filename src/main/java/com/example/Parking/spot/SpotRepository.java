package com.example.Parking.spot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Integer> {

    Spot findById(int id);

    List<Spot> getAllByReservationCustomerName(String name);

    Spot findByNumber(int number);

    Spot findByNumberAndStorey (int number, int storey);

    Spot findByStorey(int storey);
}
