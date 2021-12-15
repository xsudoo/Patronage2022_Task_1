package com.example.Parking.dto;


import com.example.Parking.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private String name;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
    }

    public Customer toEntity() {
        var customer = new Customer();
        customer.setName(this.name);
        return customer;
    }
}
