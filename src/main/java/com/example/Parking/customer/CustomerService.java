package com.example.Parking.customer;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    Customer addCustomer(Customer customer) {
        if (customerRepository.findByName(customer.getName()) != null) {
            throw new IllegalArgumentException("There is Customer with this name");
        } else return customerRepository.save(customer);
    }


}
