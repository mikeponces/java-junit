package com.pluralsight.junit.tdd;

public class EconomyFlight extends Flight {

	public EconomyFlight(String id) {
		super(id, "Economy");
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		return false;
	}

	@Override
	public boolean removePassenger(Passenger passenger) {
		return false;
	}

	@Override
	public void setDistance(Integer valueOf) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

}
