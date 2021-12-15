package com.example.Parking.dto;


import com.example.Parking.model.Customer;

public class CustomerDTO {
    private String name;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
    }

    public String getName() {
        return name;
    }

    public Customer toEntity() {
        var customer = new Customer();
        customer.setName(this.name);
        return customer;
    }
}
