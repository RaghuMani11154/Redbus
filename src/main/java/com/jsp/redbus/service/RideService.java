package com.jsp.redbus.service;
import java.util.List;
import java.util.Scanner;

import com.jsp.redbus.dao.RideDao;
import com.jsp.redbus.entity.RideEntity;
public class RideService {
	Scanner sc=new Scanner(System.in);
	RideDao rd=new RideDao();
	public void addRide(int num)
	{
		
		System.out.println("ENTER DESTINATION");
		String dest=sc.next();
		System.out.println("SET THE PRICE");
		double price=sc.nextDouble();
		System.out.println("RIDE DURATION IN HOURS");
		int time=sc.nextInt();
		RideEntity rideEntity = rd.setRide(dest,price,time);
		BusService bs=new BusService();
		bs.UpdateRide(rideEntity,num);

	}
	public void showDestination() {
		RideDao rd=new RideDao();
		List<Integer> al=rd.shoDestinatiob();
		System.out.println("USE RIDE ID TO CHOOSE BUS");
		int rid=sc.nextInt();
		boolean flag=false;
		for (Integer i: al) {
			if(i==rid)
			{
				flag=true;
			}
		}
		if(flag) {
			SeatService ss=new SeatService();
			ss.selectSeat(rid);
		}
		else {
			System.out.println("choose a valid bus");
			showDestination();
		}
		
		
	}
}
