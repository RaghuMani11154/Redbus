package com.jsp.redbus.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BusEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busId;
	private String busName;
	private int busNumber;
	
	
	
	@OneToMany(mappedBy = "bus")
	private List<SeatEntity> seat=new ArrayList<SeatEntity>();

	@OneToMany(mappedBy = "buses")
	private List<RideEntity> ride=new ArrayList<RideEntity>();
	
	public List<RideEntity> getRide() {
		return ride;
	}

	public void setRide(List<RideEntity> ride) {
		this.ride = ride;
	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public int getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(int busNumber) {
		this.busNumber = busNumber;
	}

	public List<SeatEntity> getSeat() {
		return seat;
	}

	public void setSeat(List<SeatEntity> seat) {
		this.seat = seat;
	}
	
	
	
}
