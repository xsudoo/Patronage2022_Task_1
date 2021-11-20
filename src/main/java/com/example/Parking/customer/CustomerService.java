package com.example.Parking.customer;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    final private CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }


}
