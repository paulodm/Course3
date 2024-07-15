package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.Booking;



@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{
	
	@Query("select boo.bookingid from Booking boo where boo.emailid = :emailid")
	public Integer findBookingid(@Param("emailid") String emailid);

}
