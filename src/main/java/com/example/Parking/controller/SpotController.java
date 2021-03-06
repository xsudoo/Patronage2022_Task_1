package com.example.Parking.controller;

import com.example.Parking.model.Spot;
import com.example.Parking.service.SpotService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/spot")
public class SpotController {

    final private SpotService spotService;

    public SpotController(SpotService spotService) {
        this.spotService = spotService;
    }

    @GetMapping
    List<Spot> getAllSpots() {
        return spotService.getAllSpots();
    }

    @GetMapping(params = "name")
    List<Spot> getAllSpotsByCustomer(@RequestParam String name) {
        return spotService.getAllSpotsByCustomer(name);
    }

    @GetMapping("/free")
    List<Spot> getAllFreeSpots() {
        return spotService.getAllFreeSpots();
    }

    @PostMapping
    Spot addSpot(@RequestBody @Valid Spot spot) {
        return spotService.addSpot(spot);
    }

    @GetMapping("/{id}")
    Spot getById(@PathVariable int id) {
        return spotService.getById(id);
    }
}
