package com.jsp.redbus.service;

import com.jsp.redbus.dao.BookingDao;
import com.jsp.redbus.entity.RideEntity;

public class BookingService {
	BookingDao bd=new BookingDao();
	public void addBooking(RideEntity rideEntity) {
		bd.AddBooking(rideEntity);


	}
}
