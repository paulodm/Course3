package com.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Booking;
import com.repository.BookingRepository;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	RestTemplate restTemplate;	
	
	@Autowired
    private EurekaClient eurekaClient;
	
	public String createBooking(Booking booking) {
		Integer result = bookingRepository.findBookingid(booking.getEmailid());
		if(result!= null && result >=0) {
			return "booking already exists";
		}else {
			bookingRepository.save(booking);
			return "booking created";
		}
	}
	
	
	// COURSE3_MICROSERVICEPROVIDECABFARE
	
	public String getBookingCabFare(Booking booking) {
		
		String fromBooking=booking.getFromBooking();
		String toBooking=booking.getToBooking();
		String typeofcab=booking.getTypeofcab();
		
		// Get the instance info for the microservice registered with Eureka
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("COURSE3_MICROSERVICEPROVIDECABFARE", false);

        // Construct the URL for the POST request
        String serviceUrl = instanceInfo.getHomePageUrl() + "/cabfare/getcabfare";
        
        System.out.println("estamos no metodo getBookingCabFare serviceUrl =" + serviceUrl  ) ;

		
		//String url = "http://COURSE3_MICROSERVICEPROVIDECABFARE/cabfare/getcabfare";
		
		//String url = "http://localhost:8282/cabfare/getcabfare";

		
		
		
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("fromBooking", fromBooking);
        requestBody.put("toBooking", toBooking);
        requestBody.put("typeofcab", typeofcab);

        //String response = restTemplate.postForObject(url, requestBody, String.class);
        String response = restTemplate.postForObject(serviceUrl, requestBody, String.class);
        
        
        System.out.println("estamos no metodo getBookingCabFar - response="  + response);
        return response;
		
	}

}
