package com.example.Parking.spot;

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
    List<Spot> getAllSpots(){
        return spotService.getAllSpots();
    }

    @GetMapping(params = "name")
    List<Spot> getAllSpotsByCustomer(@RequestParam String name){
        return spotService.getAllSpotsByCustomer(name);
    }
    @GetMapping("/free")
    List<Spot> getAllFreeSpots(){
        return spotService.getAllFreeSpots();
    }

    @PostMapping
    SpotDTO addSpot(@RequestBody @Valid SpotDTO spotDTO){
        return spotService.addSpot(spotDTO);
    }

    @GetMapping("/{id}")
    Spot getById(@PathVariable int id){
        return spotService.getById(id);
    }
}
