package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.entity.Booking;
import com.service.BookingService;

@Controller
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	
	
	// http://localhost:8181/
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openFirstPage() {
		
		//  
		System.out.println("estou no metodo openFirstPage ");
		return "index";		
	} // fim do openFirstPage()

	
	// http://localhost:9191/...
		
		@RequestMapping(value = "bookcabAdd",method = RequestMethod.GET)
		public String addProductPage(Booking booking,Model model) {	
			// coding
			model.addAttribute("booking", booking);		
			return "bookcab";	
		}
	
	@RequestMapping(value = "bookcab",method = RequestMethod.POST)
	public String addbookingInDbUsingThymeleafForm(Booking booking,Model model) {
		
//		int id = Integer.parseInt(req.getParameter("id"));
//		String pname= req.getParameter("pname");
//		float price = Float.parseFloat(req.getParameter("price"));
//		
//		product.setId(id);
//		product.setPname(pname);
//		product.setPrice(price);
		
		System.out.println("no metodo ddbookingInDbUsingThymeleafForm - booking.getEmailid() = " + booking.getEmailid());
		
		String result = bookingService.createBooking(booking);
		
		model.addAttribute("booking", booking);   // store product object in model scope 
		model.addAttribute("msg", result);			// req.setAttribute("msg",result);
		System.out.println(result);
		
		return "bookcab";
	}
	

	@RequestMapping(value = "cabfareGo",method = RequestMethod.GET)
	public String cabFareGo(Booking booking,Model model) {	
		// coding
		model.addAttribute("booking", booking);		
		return "cabfare";	
	}
	
	
	// http://localhost:8181/cabfare
	@RequestMapping(value = "cabfare",method = RequestMethod.POST)
	public String cabFare(Booking booking,Model model) {
		

		System.out.println("no metodo cabFare - booking.getFromBooking() = " + booking.getFromBooking());
		System.out.println("no metodo cabFare - booking.getToBooking() = " + booking.getToBooking());
		System.out.println("no metodo cabFare - booking.getTypeofcab() = " + booking.getTypeofcab());
		
		
		String result = bookingService.getBookingCabFare(booking);
//		
//		model.addAttribute("booking", booking);   // store product object in model scope 
//		model.addAttribute("msg", result);			// req.setAttribute("msg",result);
//		System.out.println(result);
		
		model.addAttribute("fareEstimate", result + " euros");
		
		return "cabfare";
	}
	
	
}
