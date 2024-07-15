package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CabFare;
import com.repository.CabFareRepository;

@Service
public class CabFareService {
	
	@Autowired
	CabFareRepository cabFareRepository;
	
	public String createCabeFare(CabFare cabFare) {
		Optional<CabFare> result = cabFareRepository.findById(cabFare.getCfId());
		if(result.isPresent()) {
			return "Cab Fare already exists";
		}else {
			cabFareRepository.save(cabFare);
			return "Cab Fare created";
		}
	}
	
	
	
	public String getCabeFare(CabFare cabFare) {
		Float result = cabFareRepository.findAmount(cabFare.getToBooking(),cabFare.getFromBooking(),cabFare.getTypeofcab());
		if(result!=null && result>=0) {
			return "Cab Fare available price =" + result;
		}else {
			return "Cab Fare not available";
		}
	}
	

}
