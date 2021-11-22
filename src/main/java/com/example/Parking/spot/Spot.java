package com.example.Parking.spot;


import com.example.Parking.reservation.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Valid
@Table(name = "spots")
public class Spot {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int storey;
    private boolean isSpotForDisabled;
    @OneToOne(mappedBy = "spot", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Reservation reservation;

    public Spot() {
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public boolean isSpotForDisabled() {
        return isSpotForDisabled;
    }

    public void setSpotForDisabled(boolean spotForDisabled) {
        isSpotForDisabled = spotForDisabled;
    }

    Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void deleteReservation() {
        this.reservation = null;
    }


}
