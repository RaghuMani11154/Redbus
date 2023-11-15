package com.jsp.redbus.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.redbus.entity.BookingEntity;
import com.jsp.redbus.entity.BusEntity;
import com.jsp.redbus.entity.RideEntity;
import com.jsp.redbus.entity.SeatEntity;

public class BookingDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(BusEntity.class).addAnnotatedClass(RideEntity.class).addAnnotatedClass(SeatEntity.class).addAnnotatedClass(BookingEntity.class);

	public void AddBooking(RideEntity rideEntity) {
		SessionFactory factory = cfg.buildSessionFactory();
		Session ses=factory.openSession();
		Transaction tr=ses.beginTransaction();
		BookingEntity be=new BookingEntity();
		be.setRide(rideEntity);
		ses.save(be);
		tr.commit();
		ses.close();

	}

}
