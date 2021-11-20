package com.example.Parking.spot;


import com.example.Parking.reservation.Reservation;

import javax.persistence.*;

@Entity
@Table(name = "spots")
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int number;
    private int storey;
    boolean isSpotForDisabled;
    @OneToOne
    private Reservation reservation;

    public Spot() {
    }

    int getId() {
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
}
