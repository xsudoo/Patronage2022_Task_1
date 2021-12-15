package com.example.Parking.service;


import com.example.Parking.dto.CustomerDTO;
import com.example.Parking.model.Customer;
import com.example.Parking.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        if (customerRepository.findByName(customerDTO.getName()) != null) {
            throw new IllegalArgumentException("There is Customer with this name");

        } else return new CustomerDTO(customerRepository.save(customerDTO.toEntity()));
    }


}
