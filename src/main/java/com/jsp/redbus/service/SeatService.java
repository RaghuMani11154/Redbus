package com.jsp.redbus.service;

import java.util.Scanner;

import com.jsp.redbus.dao.SeatDao;

public class SeatService {
	Scanner sc=new Scanner(System.in);
	SeatDao sd=new SeatDao();
	public void selectSeat(int rid) {
		System.out.println("SELECT SEATS FROM 1 TO 52");
		int seat=sc.nextInt();
		if (seat>0 && seat<53)
		{
			checkAvailability(seat,rid);
		}
		else {
			System.out.println("CHOOSE A VALID SEAT");	
			selectSeat(rid);
		}

	}
	public void checkAvailability(int seat,int rid) {
		boolean b=sd.result(seat,rid);
		if(b)
		{
			System.out.println("press 1 to book \n 2 for cancel");
			int a=sc.nextInt();
			if(a==1)
			{
				String book = sd.book(seat,rid);
				System.out.println(book);
//				System.exit(0);// should be removed
			}
			else if(a==2)
			{
				System.out.println("you've cancelled the booking THANKYOU....!");
			}
			else {
				System.out.println("choose a valid one");
				System.exit(0);//remove
			}
		}
		else {
			System.out.println("seat not available...choose other seat");
			selectSeat(rid);
		}
	}


}
