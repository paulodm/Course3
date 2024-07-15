package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.entity.CabFare;
import com.service.CabFareService;

@RestController
@RequestMapping("cabfare")
public class CabFareController {
	
	@Autowired
	CabFareService cabFareService;
	
	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createCabFare(@RequestBody CabFare cabFare) {
		return cabFareService.createCabeFare(cabFare);
	}
	
	
	@PostMapping(value = "getcabfare",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String getCabFare(@RequestBody CabFare cabFare) {
		return cabFareService.getCabeFare(cabFare);
	}

}
