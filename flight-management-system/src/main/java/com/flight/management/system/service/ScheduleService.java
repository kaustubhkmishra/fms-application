package com.flight.management.system.service;

import com.flight.management.system.exception.ResourceNotFoundException;
import com.flight.management.system.model.Schedule;
import com.flight.management.system.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: " + id));
    }

    public List<Schedule> getSchedulesByRoute(String source, String destination) {
        return scheduleRepository.findBySourceAirportAndDestinationAirport(source, destination);
    }

    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
        Schedule schedule = getScheduleById(id);
        schedule.setFlight(scheduleDetails.getFlight());
        schedule.setSourceAirport(scheduleDetails.getSourceAirport());
        schedule.setDestinationAirport(scheduleDetails.getDestinationAirport());
        schedule.setDepartureTime(scheduleDetails.getDepartureTime());
        schedule.setArrivalTime(scheduleDetails.getArrivalTime());
        return scheduleRepository.save(schedule);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
