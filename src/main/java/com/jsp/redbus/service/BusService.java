package com.jsp.redbus.service;

import java.util.Scanner;

import com.jsp.redbus.dao.BusDao;
import com.jsp.redbus.entity.RideEntity;

public class BusService {
	BusDao bd=new BusDao();
	RideService rs=new RideService();
	Scanner sc=new Scanner(System.in);
	public void chooseBusOwner() {


	}

	public void addBus() {
		System.out.println("enter bus registration number");
		int num=sc.nextInt();
		System.out.println("enter BUSNAME");
		String name=sc.next();
		bd.addBus(num,name);
		rs.addRide(num);
		
	}
	public void UpdateRide(RideEntity re,int num)
	{
		bd.updateRide(re,num);
	}



}