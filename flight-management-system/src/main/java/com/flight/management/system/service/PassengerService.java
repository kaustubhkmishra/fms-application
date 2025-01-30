package com.flight.management.system.service;

import com.flight.management.system.exception.ResourceNotFoundException;
import com.flight.management.system.model.Passenger;
import com.flight.management.system.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with id: " + id));
    }

    public Passenger getPassengerByEmail(String email) {
        return passengerRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Passenger not found with email: " + email));
    }

    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Passenger passenger = getPassengerById(id);
        passenger.setName(passengerDetails.getName());
        passenger.setEmail(passengerDetails.getEmail());
        passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}
