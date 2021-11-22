package com.example.Parking.customer;

import com.example.Parking.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
@Valid
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @NotBlank(message = "Customer name must be not null and not empty")
    @Size(min = 2, message = "Name to shor")
    @Size(max = 20, message = "Name to long")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Reservation> reservationSet = new HashSet<>();


    public Customer() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Reservation> getReservationSet() {
        return new HashSet<>(reservationSet);
    }

    public void setReservationSet(Set<Reservation> reservationList) {
        this.reservationSet = reservationList;
    }

    public void addReservation(Reservation reservation) {
        if (reservationSet.contains(reservation)) {
            return;
        }
        reservationSet.add(reservation);
        reservation.setCustomer(this);
    }

    public void deleteReservation(Reservation reservation){
        reservationSet.remove(reservation);
    }
}

