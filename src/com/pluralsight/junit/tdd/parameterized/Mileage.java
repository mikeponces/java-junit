package com.pluralsight.junit.tdd.parameterized;

import java.util.HashMap;
import java.util.Map;

import com.pluralsight.junit.tdd.Passenger;

public class Mileage {
	public static final int VIP_FACTOR = 10;
	public static final int USUAL_FACTOR = 20;

	private Map<Passenger, Integer> passengerMileageMap = new HashMap<>();
	private Map<Passenger, Integer> passengerPointsMap = new HashMap<>();
	public static int getVipFactor() {
		return VIP_FACTOR;
	}
	public static int getUsualFactor() {
		return USUAL_FACTOR;
	}
	public Map<Passenger, Integer> getPassengerMileageMap() {
		return passengerMileageMap;
	}
	public Map<Passenger, Integer> getPassengerPointsMap() {
		return passengerPointsMap;
	}
	public void calculateGivenPoints() {
		// TODO Auto-generated method stub

	}
	public void addMilage(Passenger passenger, int distance) {
		// TODO Auto-generated method stub

	}
}
