package com.jsp.redbus.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.redbus.entity.BookingEntity;
import com.jsp.redbus.entity.BusEntity;
import com.jsp.redbus.entity.RideEntity;
import com.jsp.redbus.entity.SeatEntity;

public class RideDao {

	Configuration cfg=new Configuration().configure().addAnnotatedClass(BusEntity.class).addAnnotatedClass(RideEntity.class).addAnnotatedClass(SeatEntity.class).addAnnotatedClass(BookingEntity.class);
	
	public RideEntity setRide(String dest, double price, int time) {
		
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		RideEntity re=new RideEntity();
		re.setRideDestination(dest);
		re.setRidePrice(price);
		re.setRideDuration(time);
		
		ses.save(re);
		System.out.println("SUCCESSFULLY LOGGED IN 🤍 ENJOY YOUR TRAVEL........!");
		tr.commit();
		ses.close();
		return re;
	}

	public List<Integer> shoDestinatiob() {
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		ArrayList<Integer> al=new ArrayList<>();
		@SuppressWarnings("unchecked")
		Query<RideEntity> q=ses.createQuery("from RideEntity");
		List<RideEntity> li=q.list();
		for (RideEntity rideEntity : li) {
			System.out.println("DESTINATION:->"+rideEntity.getRideDestination()+"   PRICE:->"+rideEntity.getRidePrice()+"   DURATION:->"+rideEntity.getRideDuration()+"hr    RIDEID:->"+rideEntity.getRideId());
			al.add(rideEntity.getRideId());
		}
		ses.close();
		return al;
		
	}

}
