package com.jsp.redbus.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jsp.redbus.entity.CustomerEntity;
import com.jsp.redbus.service.CustomerService;

public class CustomerDao {

	Configuration cfg=new Configuration().configure().addAnnotatedClass(CustomerEntity.class);


	public void setUserPass(String cName, String pas) {
		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tr=ses.beginTransaction();
		CustomerEntity ce=new CustomerEntity();
		ce.setcName(cName);
		ce.setPass(pas);
		ses.save(ce);
		System.out.println("SUCCESSFULLY LOGGED IN 🤍 ENJOY YOUR TRAVEL........!");
		System.out.println(ce.getcId()+" this is your customerId");
		tr.commit();
		ses.close();
	}


	public String[] getAccess(int cid) {

		SessionFactory sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		CustomerEntity ce=ses.get(CustomerEntity.class, cid);
//		System.out.println(ce.getcId()+ce.getcName()+ce.getPass());
		String s[]=new String[3];
		if(ce==null) 
		{
			System.out.println("No user found please sign in ");
			CustomerService cs=new CustomerService();
			cs.signUp();
			ses.close();
			System.exit(0);
		}
		else
		{
			s[0]=ce.getcId()+"";
			s[1]=ce.getcName();
			s[2]=ce.getPass();
			ses.close();
		}

		return s;


	}

}
