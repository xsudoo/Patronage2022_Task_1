package com.example.Parking.reservation;

public class ReservationDTO {
    private int spotId;
    private int customerId;

    public ReservationDTO() {
    }

    /*public ReservationDTO(Reservation reservation){
        this.spotId = reservation.getSpot().getId();
        this.customerId = reservation.getCustomer().getId();
    }*/

    public int getSpotId() {
        return spotId;
    }


    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


}
