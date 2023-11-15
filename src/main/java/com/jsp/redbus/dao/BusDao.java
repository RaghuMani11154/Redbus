package com.jsp.redbus.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.redbus.entity.BookingEntity;
import com.jsp.redbus.entity.BusEntity;
import com.jsp.redbus.entity.RideEntity;
import com.jsp.redbus.entity.SeatEntity;
import org.hibernate.query.Query;

public class BusDao {
	Configuration cfg=new Configuration().configure().addAnnotatedClass(BusEntity.class).addAnnotatedClass(RideEntity.class).addAnnotatedClass(SeatEntity.class).addAnnotatedClass(BookingEntity.class);

	public void addBus(int num, String name) {
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		BusEntity be=new BusEntity();
		be.setBusName(name);
		be.setBusNumber(num);
		SeatEntity se=new SeatEntity();
		se.setBus(be);
		ses.save(be);
		System.out.println("SUCCESSFULLY ADDED YOUR BUS 🤍 NOW PEOPLE CAN ENJOY YOUR SERVICESSSSSS........!");
		System.out.println(be.getBusId()+" this is your BUSId");
		tr.commit();
		ses.close();
		
	}
	public void updateRide(RideEntity lr, int num)
	{
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		CriteriaBuilder cb = ses.getCriteriaBuilder();
		CriteriaQuery<BusEntity> cu=cb.createQuery(BusEntity.class);
		Root<BusEntity> r= cu.from(BusEntity.class);
		cu.where(cb.equal(r.get("busNumber"), num));
		Query<BusEntity> q=ses.createQuery(cu);
		List<BusEntity> li=q.list();
		BusEntity busEntity = li.get(0);
		busEntity.getRide().add(lr);
	
		ses.update(busEntity);
		lr.setBuses(busEntity);
		ses.update(lr);
		System.out.println("WORK DONE..............................................................");
		tr.commit();
		ses.close();
	}
	public void updateSeat(SeatEntity lr)
	{
		
	}

}
