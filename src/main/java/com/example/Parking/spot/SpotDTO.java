package com.example.Parking.spot;

public class SpotDTO {
    private int number;
    private int storey;
    private boolean isSpotForDisabled;
    //private int reservationId;

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

   /* public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }*/
}
