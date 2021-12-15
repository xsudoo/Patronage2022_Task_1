package com.example.Parking.spot;

import com.example.Parking.model.Spot;
import com.example.Parking.repository.SpotRepository;
import com.example.Parking.model.Reservation;
import com.example.Parking.service.SpotService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpotServiceTest {

    @Autowired
    private SpotService spotService;
    @MockBean
    private SpotRepository spotRepository;


    @Test
    void shouldGetListOfSpots() {
        //given
        List<Spot> spotList = prepareListOfMockData();
        //when
        when(spotService.getAllSpots()).thenReturn(spotList);
        //then
        assertEquals(spotService.getAllSpots(), spotList);
    }

    @Test
    void addingNewSpot() {
        //given
        var spot = prepareSingleMockData();
        //when
        spotService.addSpot(spot);
        //then
        verify(spotRepository).save(any(Spot.class));
    }

    @Test
    void getExceptionWhenPostTheSameNumberNadStorey() {
        //given
        var spot = prepareSingleMockData();
        //when
        when(spotRepository.findByNumberAndStorey(spot.getNumber(), spot.getStorey())).thenReturn(spot);
        //then
        assertThrows(IllegalArgumentException.class, () -> spotService.addSpot(spot));
    }

    @Test
    void getAllFreeSpot() {
        //given
        var spot = prepareListOfMockData();
        spot.forEach(s -> s.setReservation(null));
        //when
        when(spotRepository.findAll()).thenReturn(spot);
        //then
        assertEquals(2, spotService.getAllFreeSpots().size());
    }

    @Test
    void getSpotById() {
        //given
        var spot = prepareSingleMockData();
        //when
        when(spotRepository.findById(spot.getId())).thenReturn(spot);
        var spot2 = spotRepository.findById(spot.getId());
        //then
        assertEquals(spot, spot2);


    }


    private List<Spot> prepareListOfMockData() {
        var s1 = new Spot();
        s1.setStorey(1);
        s1.setNumber(1);
        s1.setReservation(new Reservation());

        var s2 = new Spot();
        s2.setNumber(2);
        s2.setStorey(2);
        s2.setReservation(new Reservation());

        List<Spot> spotList = new ArrayList<>();
        spotList.add(s1);
        spotList.add(s2);

        return spotList;
    }

    private Spot prepareSingleMockData() {
        var s1 = new Spot();
        s1.setStorey(1);
        s1.setNumber(1);
        s1.setReservation(new Reservation());
        return s1;
    }

}