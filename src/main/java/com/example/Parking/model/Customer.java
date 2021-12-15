package com.example.Parking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
@Valid
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;
    @NotBlank(message = "Customer name must be not null and not empty")
    @Size(min = 3, message = "Name to short")
    @Size(max = 20, message = "Name to long")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer", fetch = FetchType.LAZY)
    private Set<Reservation> reservationSet = new HashSet<>();

    Set<Reservation> getReservationSet() {
        return new HashSet<>(reservationSet);
    }

    void addReservation(Reservation reservation) {
        if (reservationSet.contains(reservation)) {
            return;
        }
        reservationSet.add(reservation);
        reservation.setCustomer(this);
    }

    public void deleteReservation(Reservation reservation) {
        reservationSet.remove(reservation);
    }
}

