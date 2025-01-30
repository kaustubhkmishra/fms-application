package com.flight.management.system.init;

import com.flight.management.system.model.*;
import com.flight.management.system.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DataInitializationService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @PostConstruct
    public void initData() {
        initializeFlights();
        initializeAirports();
        initializeSchedules();
        initializeScheduledFlights();
        initializePassengers();
        initializeBookings();
    }

    private void initializeFlights() {
        if (flightRepository.count() == 0) {
            Flight flight1 = new Flight();
            flight1.setFlightNo(new BigInteger("1001"));
            flight1.setCarrierName("Air India");
            flight1.setFlightModel("Boeing 747");
            flight1.setSeatCapacity(300);

            Flight flight2 = new Flight();
            flight2.setFlightNo(new BigInteger("1002"));
            flight2.setCarrierName("Indigo");
            flight2.setFlightModel("Airbus A320");
            flight2.setSeatCapacity(180);

            flightRepository.saveAll(List.of(flight1, flight2));
        }
    }

    private void initializeAirports() {
        if (airportRepository.count() == 0) {
            Airport airport1 = new Airport();
            airport1.setAirportCode("DEL");
            airport1.setAirportName("Indira Gandhi International Airport");
            airport1.setCity("Delhi");
            airport1.setCountry("India");

            Airport airport2 = new Airport();
            airport2.setAirportCode("BOM");
            airport2.setAirportName("Chhatrapati Shivaji Maharaj International Airport");
            airport2.setCity("Mumbai");
            airport2.setCountry("India");

            Airport airport3 = new Airport();
            airport3.setAirportCode("JFK");
            airport3.setAirportName("John F. Kennedy International Airport");
            airport3.setCity("New York");
            airport3.setCountry("USA");

            airportRepository.saveAll(List.of(airport1, airport2, airport3));
        }
    }

    private void initializeSchedules() {
        if (scheduleRepository.count() == 0) {
            Flight flight1 = flightRepository.findById(1L).orElseThrow();
            Flight flight2 = flightRepository.findById(2L).orElseThrow();

            Schedule schedule1 = new Schedule();
            schedule1.setFlight(flight1);
            schedule1.setSourceAirport("DEL");
            schedule1.setDestinationAirport("BOM");
            schedule1.setDepartureTime(LocalDateTime.of(2025, 2, 1, 10, 0));
            schedule1.setArrivalTime(LocalDateTime.of(2025, 2, 1, 12, 0));

            Schedule schedule2 = new Schedule();
            schedule2.setFlight(flight2);
            schedule2.setSourceAirport("JFK");
            schedule2.setDestinationAirport("DEL");
            schedule2.setDepartureTime(LocalDateTime.of(2025, 2, 2, 15, 0));
            schedule2.setArrivalTime(LocalDateTime.of(2025, 2, 3, 3, 0));

            scheduleRepository.saveAll(List.of(schedule1, schedule2));
        }
    }

    private void initializeScheduledFlights() {
        if (scheduledFlightRepository.count() == 0) {
            Schedule schedule1 = scheduleRepository.findById(1L).orElseThrow();
            Schedule schedule2 = scheduleRepository.findById(2L).orElseThrow();

            ScheduledFlight scheduledFlight1 = new ScheduledFlight();
            scheduledFlight1.setFlight(schedule1.getFlight());
            scheduledFlight1.setSchedule(schedule1);
            scheduledFlight1.setAvailableSeats(schedule1.getFlight().getSeatCapacity());

            ScheduledFlight scheduledFlight2 = new ScheduledFlight();
            scheduledFlight2.setFlight(schedule2.getFlight());
            scheduledFlight2.setSchedule(schedule2);
            scheduledFlight2.setAvailableSeats(schedule2.getFlight().getSeatCapacity());

            scheduledFlightRepository.saveAll(List.of(scheduledFlight1, scheduledFlight2));
        }
    }

    private void initializePassengers() {
        if (passengerRepository.count() == 0) {
            Passenger passenger1 = new Passenger();
            passenger1.setName("John Doe");
            passenger1.setEmail("john.doe@example.com");
            passenger1.setPhoneNumber("9876543210");

            Passenger passenger2 = new Passenger();
            passenger2.setName("Alice Johnson");
            passenger2.setEmail("alice.johnson@example.com");
            passenger2.setPhoneNumber("9123456789");

            passengerRepository.saveAll(List.of(passenger1, passenger2));
        }
    }

    private void initializeBookings() {
        if (bookingRepository.count() == 0) {
            Flight flight1 = flightRepository.findById(1L).orElseThrow();
            Flight flight2 = flightRepository.findById(2L).orElseThrow();

            Booking booking1 = new Booking();
            booking1.setPassengerName("John Doe");
            booking1.setEmail("john.doe@example.com");
            booking1.setFlight(flight1);
            booking1.setBookingDate(LocalDateTime.now());
            booking1.setStatus("CONFIRMED");

            Booking booking2 = new Booking();
            booking2.setPassengerName("Alice Johnson");
            booking2.setEmail("alice.johnson@example.com");
            booking2.setFlight(flight2);
            booking2.setBookingDate(LocalDateTime.now());
            booking2.setStatus("CONFIRMED");

            bookingRepository.saveAll(List.of(booking1, booking2));
        }
    }
}
