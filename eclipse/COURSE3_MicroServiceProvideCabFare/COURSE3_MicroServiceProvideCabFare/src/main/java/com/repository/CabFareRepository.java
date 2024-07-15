package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.CabFare;



@Repository
public interface CabFareRepository extends JpaRepository<CabFare, Integer>{

	
	//@Query("select boo.bookingid from Booking boo where boo.emailid = :emailid")
	@Query("Select cf.amount from CabFare cf where cf.toBooking=:toBooking and cf.fromBooking=:fromBooking and cf.typeofcab=:typeofcab")
	public Float findAmount(@Param("toBooking") String toBooking, 
            @Param("fromBooking") String fromBooking, 
            @Param("typeofcab") String typeofcab);
}
