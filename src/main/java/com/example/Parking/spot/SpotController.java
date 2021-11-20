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

    @PostMapping
    Spot addSpot(@RequestBody @Valid Spot spot){
        return spotService.addSpot(spot);
    }
}
