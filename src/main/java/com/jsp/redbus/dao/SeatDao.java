package com.jsp.redbus.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import com.jsp.redbus.entity.*;
import com.jsp.redbus.service.BookingService;

public class SeatDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(BusEntity.class).addAnnotatedClass(RideEntity.class).addAnnotatedClass(SeatEntity.class).addAnnotatedClass(BookingEntity.class);


	public boolean result(int seat, int rid) {
		boolean flag=true;
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		RideEntity rideEntity = ses.get(RideEntity.class, rid);
		BusEntity buses = rideEntity.getBuses();
		int a=buses.getBusId();
		@SuppressWarnings("unchecked")
		NativeQuery<Integer> q=ses.createNativeQuery("select s.seatNo from SeatEntity s where s.bus_busId="+a);
		
		if(q==null) 
			{
			flag=true;
			ses.close();
			return flag;
			}
		List<Integer> li=q.list();
		for (Integer seatEntity : li) {
			if(seatEntity==seat)
			{
				flag=false;
			}
		}
		
		ses.close();
		return flag;
	}

	public String book(int seat, int bid) {
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		SeatEntity se=new SeatEntity();
		se.setSeatNo(seat);
		RideEntity rideEntity = ses.get(RideEntity.class, bid);
		BusEntity buses = rideEntity.getBuses();
//		BusEntity bus = ses.get(BusEntity.class, 14);
		System.out.println("this is busssssssssssssssssssssssssssssssssss"+buses);
		BookingService bs=new BookingService();
		
		se.setBus(buses);
		ses.save(se);
		
//		App.hi(rideEntity);//removed
		tr.commit();
		ses.close();
		bs.addBooking(rideEntity);
		return "YOU HAVE BOOKED YOUR SEAT HAPPY JOURNEY.....💕🙋‍♀️";
		
	}

}
