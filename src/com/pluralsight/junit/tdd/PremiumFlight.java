package com.pluralsight.junit.tdd;

public class PremiumFlight extends Flight {

	public PremiumFlight(String id) {
		super(id, "Premium");
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
