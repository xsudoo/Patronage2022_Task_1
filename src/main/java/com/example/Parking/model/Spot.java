package com.example.Parking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;

@Getter
@Setter
@NoArgsConstructor
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

    @JsonIgnore
    public Reservation getReservation() {
        return reservation;
    }

    public void deleteReservation() {
        this.reservation = null;
    }


}
