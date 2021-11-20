package com.example.Parking.customer;

import com.example.Parking.reservation.Reservation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Customer name must be not null and not empty")
    @Size(min = 2, max = 20)
   // @Column(unique = true)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservationList;


    public Customer() {
    }


    int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
