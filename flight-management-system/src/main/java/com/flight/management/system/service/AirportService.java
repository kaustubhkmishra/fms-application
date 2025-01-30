package com.flight.management.system.service;

import com.flight.management.system.exception.ResourceNotFoundException;
import com.flight.management.system.model.Airport;
import com.flight.management.system.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Airport getAirportById(Long id) {
        return airportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found with id: " + id));
    }

    public Airport getAirportByCode(String airportCode) {
        return airportRepository.findByAirportCode(airportCode)
                .orElseThrow(() -> new ResourceNotFoundException("Airport not found with code: " + airportCode));
    }

    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }
}
