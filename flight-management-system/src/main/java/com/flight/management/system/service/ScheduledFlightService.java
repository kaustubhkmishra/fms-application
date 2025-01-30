package com.flight.management.system.service;

import com.flight.management.system.exception.ResourceNotFoundException;
import com.flight.management.system.model.ScheduledFlight;
import com.flight.management.system.repository.ScheduledFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledFlightService {

    @Autowired
    private ScheduledFlightRepository scheduledFlightRepository;

    public List<ScheduledFlight> getAllScheduledFlights() {
        return scheduledFlightRepository.findAll();
    }

    public ScheduledFlight getScheduledFlightById(Long id) {
        return scheduledFlightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Scheduled Flight not found with id: " + id));
    }

    public List<ScheduledFlight> getScheduledFlightsByFlightId(Long flightId) {
        return scheduledFlightRepository.findByFlightId(flightId);
    }

    public List<ScheduledFlight> getScheduledFlightsByScheduleId(Long scheduleId) {
        return scheduledFlightRepository.findByScheduleId(scheduleId);
    }

    public ScheduledFlight saveScheduledFlight(ScheduledFlight scheduledFlight) {
        return scheduledFlightRepository.save(scheduledFlight);
    }

    public ScheduledFlight updateScheduledFlight(Long id, ScheduledFlight updatedScheduledFlight) {
        ScheduledFlight existingScheduledFlight = getScheduledFlightById(id);
        existingScheduledFlight.setFlight(updatedScheduledFlight.getFlight());
        existingScheduledFlight.setSchedule(updatedScheduledFlight.getSchedule());
        existingScheduledFlight.setAvailableSeats(updatedScheduledFlight.getAvailableSeats());
        return scheduledFlightRepository.save(existingScheduledFlight);
    }

    public void deleteScheduledFlight(Long id) {
        scheduledFlightRepository.deleteById(id);
    }
}
