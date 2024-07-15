package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CabFare {

	
	@Id // PK 
	private int cfId;
	private String fromBooking;
	private String toBooking;
	private String typeofcab;
	private float amount;
	
	
	
	public int getCfId() {
		return cfId;
	}
	public void setCfId(int cfId) {
		this.cfId = cfId;
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	
}
