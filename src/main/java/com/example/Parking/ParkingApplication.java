package com.example.Parking;

import com.example.Parking.customer.Customer;
import com.example.Parking.customer.CustomerRepository;
import com.example.Parking.spot.Spot;
import com.example.Parking.spot.SpotRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class ParkingApplication implements ApplicationListener<ContextRefreshedEvent> {

	private final CustomerRepository customerRepository;
	private final SpotRepository spotRepository;

	public ParkingApplication(CustomerRepository customerRepository, SpotRepository spotRepository) {
		this.customerRepository = customerRepository;
		this.spotRepository = spotRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/*var customer = new Customer();
		customer.setName("Jhon");
		var spot = new Spot();
		spot.setNumber(1);
		spot.setStorey(1);
		spot.setSpotForDisabled(false);

		customerRepository.save(customer);
		spotRepository.save(spot);*/
	}
}
