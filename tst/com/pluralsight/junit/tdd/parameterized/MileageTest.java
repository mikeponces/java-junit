package com.pluralsight.junit.tdd.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.pluralsight.junit.tdd.Flight;
import com.pluralsight.junit.tdd.Passenger;

class MileageTest {

	private Mileage mileage;

	@BeforeAll
	void beforeAll() {
		mileage = new Mileage();
	}

	@ParameterizedTest
	@Disabled
	@ValueSource(strings = { "1; e; Mike; false; 349", "2; b; John; true; 278", "3; e; Mike; false; 319",
			"4; p; John; true; 817", "5; e; Mike; false; 623", "6; e; John; true; 978" })
	void checkGivenPoints(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for (Passenger passenger : flight.getPassengerList()) {
			mileage.addMilage(passenger, flight.getDistance());
		}
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/flights_information.csv")
	void checkGivenPointsWithCsvInput(@ConvertWith(FlightArgumentConverter.class) Flight flight) {
		for (Passenger passenger : flight.getPassengerList()) {
			mileage.addMilage(passenger, flight.getDistance());
		}
	}

	@AfterAll
	void afterAll() {
		mileage.calculateGivenPoints();
		assertEquals(64, mileage.getPassengerPointsMap().get(new Passenger("Mike", false)).intValue());
		assertEquals(207, mileage.getPassengerPointsMap().get(new Passenger("John", true)).intValue());
		System.out.println(mileage.getPassengerPointsMap());
	}

}
