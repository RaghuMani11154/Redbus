package com.jsp.firstsignin;

import java.util.Scanner;

public class Selector {
	Scanner sc=new Scanner(System.in);
	public void choose() {
		System.out.println("PRESS ONE IF YOU ARE CUSTOMER OR TYPE TWO IF YOU ARE A VUS OWNER");
		int a=sc.nextInt();
		switch(a)
		{
		case 1:System.out.println("you are a customer");
		Customer cust=new Customer();
		cust.choose();
		break;
		case 2: 
			System.out.println("you are a owner");
			BusOwner bo=new BusOwner();
			bo.choose();
		}
	}

}
