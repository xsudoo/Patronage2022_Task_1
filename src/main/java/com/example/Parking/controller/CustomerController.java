package com.example.Parking.controller;

import com.example.Parking.dto.CustomerDTO;
import com.example.Parking.service.CustomerService;
import com.example.Parking.model.Customer;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    final private CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public CustomerDTO addCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }
}
