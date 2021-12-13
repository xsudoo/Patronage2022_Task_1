package com.example.Parking.controller;

import com.example.Parking.model.Reservation;
import com.example.Parking.dto.ReservationDTO;
import com.example.Parking.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {


    final private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservation() {
        return reservationService.getAllReservation();
    }

    @GetMapping(params = "name")
    public List<Reservation> getAllByCustomer(@RequestParam String name) {
        return reservationService.getAllByCustomer(name);
    }

    @PostMapping
    public ReservationDTO addReservation(@RequestBody @Valid ReservationDTO reservationDTO) {
        return reservationService.addReservation(reservationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationDTO> delete(@PathVariable int id) {
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }
}
