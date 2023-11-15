package com.jsp.firstsignin;

import java.util.Scanner;

import com.jsp.redbus.service.CustomerService;

public class Customer {
	Scanner sc=new  Scanner(System.in);
	CustomerService cs=new CustomerService();
	public void choose() {
		System.out.println("press 1 for login \n press 2 for signup");
		int a=sc.nextInt();
		switch(a)
		{
		case 1:System.out.println("you want to login");
		cs.login();
		
		break;
		case 2: 
		System.out.println("you want to sign in");
		cs.signUp();
		}
		
	}

}
