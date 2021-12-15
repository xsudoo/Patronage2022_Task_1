package com.example.Parking.spot;

import com.example.Parking.model.Reservation;
import com.example.Parking.model.Spot;
import com.example.Parking.service.SpotService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class SpotControllerTest {


    @Autowired
    SpotService spotService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetSingleSpotById() throws Exception {
        //given

        //when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/spot/1").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is(200));

    }

    @Test
    void shouldGetListOfSpots() throws Exception {
        //given
        spotService.addSpot(prepareListOfMockData().get(0));
        spotService.addSpot(prepareListOfMockData().get(1));
        //when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/spot")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }
    @Test
    void addingSpot() throws Exception {
        //given

        //when

        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/spot").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":3,\"storey\":3,\"spotForDisabled\":false}"))
                .andExpect(status().isOk());
    }




    private List<Spot> prepareListOfMockData() {
        var s1 = new Spot();
        s1.setStorey(1);
        s1.setNumber(1);
        s1.setReservation(null);

        var s2 = new Spot();
        s2.setNumber(2);
        s2.setStorey(2);
        s2.setReservation(null);

        List<Spot> spotList = new ArrayList<>();
        spotList.add(s1);
        spotList.add(s2);

        return spotList;
    }

    private Spot prepareSingleMockData() {
        var s1 = new Spot();
        s1.setStorey(1);
        s1.setNumber(1);
        s1.setReservation(null);
        return s1;
    }
}