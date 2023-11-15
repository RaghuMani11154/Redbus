package com.jsp.redbus.service;

import java.util.Scanner;

import com.jsp.redbus.dao.CustomerDao;

public class CustomerService {
	 CustomerDao cd=new CustomerDao();
	 Scanner sc=new Scanner(System.in);
	 
	 public void signUp()
	 {
		 UserName();
		 login();
	 }
	 public void login()
	 {
		System.out.println("Enter your CustomerID to LogIn");
		int id=sc.nextInt();
		String s[]=cd.getAccess(id);
		System.out.println("ENTER YOUR NAME");
		String name=sc.next();
		System.out.println("ENTER YOUR PASSWORD");
		String pass=sc.next();
		if(Integer.parseInt(s[0])==id && name.equals(s[1]) && pass.equals(s[2]))
		{
			System.out.println("tell me the destination");
			RideService rs=new RideService();
			rs.showDestination();
		}
		else if(Integer.parseInt(s[0])==id)
		{
			System.out.println("invalid USER OR PASS");
		}
		else
		{
			System.out.println("no account found please signin");
			
		}
		
	 }
	 public void getUser()
	 {
		 System.out.println("Enter User");
		 		 
	 }
	 public void getPass() {
		 System.out.println("Enter pass");
	 }
	 public void UserName()
	 {
		 System.out.println("enter user name");
		 String name=sc.next();
		 String pas=pass();
		 cd.setUserPass(name,pas);
	 }

	public String pass() {
		System.out.println("ENTER PASSWORD");
		String pas=sc.next();
		System.out.println("RE-ENTER PASSWORD");
		String re=sc.next();
		if(pas.equals(re))
		{
			return re;
		}
		else {
			System.out.println("INVALID PASSWORD RE TRY");
			System.exit(0);
		}
		return re;
	}
}
