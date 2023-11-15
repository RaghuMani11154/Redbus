package com.jsp.firstsignin;

import java.util.Scanner;

import com.jsp.redbus.service.BusService;

public class BusOwner {
	BusService bs=new BusService();
	Scanner sc=new Scanner(System.in);
	public void choose() {
		System.out.println("enter 1 for add bus \n enter 2 for remove service");
		int a=sc.nextInt();
		
		switch (a) {
		case 1:
			bs.addBus();
			break;
			
		case 2:
			System.out.println("you can't able to remove bus contact customer care");
			break;
		default:
			break;
		}
	}

}
