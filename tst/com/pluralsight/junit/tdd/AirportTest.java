package com.pluralsight.junit.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AirportTest {

	@DisplayName("Given there is an economy flight")
	@Nested
	class EconomyFlightTest {

		private Flight economyFlight;
		private Passenger mike;
		private Passenger john;

		@BeforeEach
		void setUp() {
			economyFlight = new EconomyFlight("1");
			mike = new Passenger("Mike", false);
			john = new Passenger("John", true);
		}

		@Nested
		@DisplayName("When we have a usual passenger")
		class UsualPassenger {

			@Test
			@DisplayName("Then you can add and remove him from an economy flight")
			public void testEconomyFlightUsualPassenger() {
				assertAll("Verify all conditions for a usual passenger and an economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(mike)),
						() -> assertEquals(1, economyFlight.getPassengerList().size()),
						() -> assertEquals("Mike", economyFlight.getPassengerList().get(0).getName()),
						() -> assertEquals(true, economyFlight.removePassenger(mike)),
						() -> assertEquals(0, economyFlight.getPassengerList().size()));
			}
		}

		@Nested
		@DisplayName("When we have a VIP passenger")
		class VipPassenger {
			@Test
			@DisplayName("Then you can add him but cannot remove him from an economy flight")
			public void testEconomyFlightVipPassenger() {
				assertAll("Verify all conditions for a VIP passenger and an economy flight",
						() -> assertEquals("1", economyFlight.getId()),
						() -> assertEquals(true, economyFlight.addPassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengerList().size()),
						() -> assertEquals("John", economyFlight.getPassengerList().get(0).getName()),
						() -> assertEquals(false, economyFlight.removePassenger(john)),
						() -> assertEquals(1, economyFlight.getPassengerList().size()));

			}
		}

	}

	@DisplayName("Given there is a business flight")
	@Nested
	class BusinessFlightTest {
		private Flight businessFlight;

		@BeforeEach
		void setUp() {
			businessFlight = new BusinessFlight("2");
		}

		@Test
		public void testBusinessFlightUsualPassenger() {
			Passenger mike = new Passenger("Mike", false);

			assertEquals(false, businessFlight.addPassenger(mike));
			assertEquals(0, businessFlight.getPassengerList().size());
			assertEquals(false, businessFlight.removePassenger(mike));
			assertEquals(0, businessFlight.getPassengerList().size());

		}

		@Test
		public void testBusinessFlightVipPassenger() {
			Passenger john = new Passenger("John", true);

			assertEquals(true, businessFlight.addPassenger(john));
			assertEquals(1, businessFlight.getPassengerList().size());
			assertEquals(false, businessFlight.removePassenger(john));
			assertEquals(1, businessFlight.getPassengerList().size());

		}

	}
}
