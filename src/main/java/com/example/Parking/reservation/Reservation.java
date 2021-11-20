package com.example.Parking.reservation;


import com.example.Parking.customer.Customer;
import com.example.Parking.spot.Spot;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "spot_id", referencedColumnName = "id")
    private Spot spot;

    public Reservation() {
    }

    public int getId() {
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

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}
