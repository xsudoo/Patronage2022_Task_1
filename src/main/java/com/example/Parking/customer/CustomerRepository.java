package com.example.Parking.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findById(int id);

    Customer findByName(String name);
}
