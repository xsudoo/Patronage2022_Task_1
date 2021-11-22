package com.example.Parking.reservation;


import com.example.Parking.customer.Customer;
import com.example.Parking.spot.Spot;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Valid
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private Customer customer;
    @OneToOne
    @MapsId
    private Spot spot;

    public Reservation() {
    }

    @JsonIgnore
    int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Spot getSpot() {
        return spot;
    }

    void setSpot(Spot spot) {
        this.spot = spot;
    }
}
