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
public class RideEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rideId;
	private String rideDestination;
	private double ridePrice;
	private int rideDuration;
	
	@OneToMany(mappedBy = "Ride")
	private List<BookingEntity> book=new ArrayList<BookingEntity>();
	
	@ManyToOne
	private BusEntity buses;

	public int getRideId() {
		return rideId;
	}

	public void setRideId(int rideId) {
		this.rideId = rideId;
	}

	public String getRideDestination() {
		return rideDestination;
	}

	public void setRideDestination(String rideDestination) {
		this.rideDestination = rideDestination;
	}

	public double getRidePrice() {
		return ridePrice;
	}

	public void setRidePrice(double ridePrice) {
		this.ridePrice = ridePrice;
	}

	public int getRideDuration() {
		return rideDuration;
	}

	public void setRideDuration(int rideDuration) {
		this.rideDuration = rideDuration;
	}

	public List<BookingEntity> getBook() {
		return book;
	}

	public void setBook(List<BookingEntity> book) {
		this.book = book;
	}

	public BusEntity getBuses() {
		return buses;
	}

	public void setBuses(BusEntity buses) {
		this.buses = buses;
	}
	
	
	
	
	
}
