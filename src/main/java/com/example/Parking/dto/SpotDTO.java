package com.example.Parking.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SpotDTO {
    private int number;
    private int storey;
    private boolean isSpotForDisabled;

}
