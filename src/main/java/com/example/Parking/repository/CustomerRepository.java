package com.example.Parking.repository;

import com.example.Parking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int id);

    Customer findByName(String name);
}
