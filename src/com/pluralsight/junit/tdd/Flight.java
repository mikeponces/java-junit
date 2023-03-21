package com.pluralsight.junit.tdd;

import java.util.ArrayList;
import java.util.List;

public abstract class Flight {
	private String id;
	private String flightType;
	protected List<Passenger> passengerList = new ArrayList<>();

	public Flight(String id, String flightType) {
		this.id = id;
		this.flightType = flightType;
	}

	public abstract boolean addPassenger(Passenger passenger);

	public abstract boolean removePassenger(Passenger passenger);

	public abstract void setDistance(Integer valueOf);

	public String getId() {
		return id;
	}

	public String getFlightType() {
		return flightType;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public abstract int getDistance();


}
