package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
	
	@Id // PK 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	@Column(unique = true)  // unique
	private String emailid;
	private String fromBooking;
	private String toBooking;
	private String typeofcab;
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getFromBooking() {
		return fromBooking;
	}
	public void setFromBooking(String fromBooking) {
		this.fromBooking = fromBooking;
	}
	public String getToBooking() {
		return toBooking;
	}
	public void setToBooking(String toBooking) {
		this.toBooking = toBooking;
	}
	public String getTypeofcab() {
		return typeofcab;
	}
	public void setTypeofcab(String typeofcab) {
		this.typeofcab = typeofcab;
	}
	
	
	


}
