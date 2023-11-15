package com.jsp.redbus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class SeatEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatId;
	private int seatNo;
	
	@ManyToOne
	private BusEntity bus;
	  
	
	@OneToMany
	private List<BookingEntity> book=new ArrayList<BookingEntity>();


	public int getSeatId() {
		return seatId;
	}


	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public BusEntity getBus() {
		return bus;
	}


	public void setBus(BusEntity bus) {
		this.bus = bus;
	}


	public List<BookingEntity> getBook() {
		return book;
	}


	public void setBook(List<BookingEntity> book) {
		this.book = book;
	}
	
	

}
