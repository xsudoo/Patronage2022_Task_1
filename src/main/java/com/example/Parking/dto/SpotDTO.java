package com.example.Parking.dto;

public class SpotDTO {
    private int number;
    private int storey;
    private boolean isSpotForDisabled;

    public SpotDTO() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public boolean isSpotForDisabled() {
        return isSpotForDisabled;
    }

    public void setSpotForDisabled(boolean spotForDisabled) {
        isSpotForDisabled = spotForDisabled;
    }
}
