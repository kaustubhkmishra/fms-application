package com.flight.management.system.controller;


import com.flight.management.system.model.ScheduledFlight;
import com.flight.management.system.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduledFlights")
public class ScheduledFlightController {

    @Autowired
    private ScheduledFlightService scheduledFlightService;

    @GetMapping
    public List<ScheduledFlight> getAllScheduledFlights() {
        return scheduledFlightService.getAllScheduledFlights();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getScheduledFlightById(@PathVariable Long id) {
        ScheduledFlight scheduledFlight = scheduledFlightService.getScheduledFlightById(id);
        return ResponseEntity.ok(scheduledFlight);
    }

    @GetMapping("/flight/{flightId}")
    public List<ScheduledFlight> getScheduledFlightsByFlightId(@PathVariable Long flightId) {
        return scheduledFlightService.getScheduledFlightsByFlightId(flightId);
    }

    @GetMapping("/schedule/{scheduleId}")
    public List<ScheduledFlight> getScheduledFlightsByScheduleId(@PathVariable Long scheduleId) {
        return scheduledFlightService.getScheduledFlightsByScheduleId(scheduleId);
    }

    @PostMapping
    public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
        return scheduledFlightService.saveScheduledFlight(scheduledFlight);
    }

    @PutMapping("/{id}")
    public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight) {
        return scheduledFlightService.updateScheduledFlight(id, scheduledFlight);
    }

    @DeleteMapping("/{id}")
    public void deleteScheduledFlight(@PathVariable Long id) {
        scheduledFlightService.deleteScheduledFlight(id);
    }
}
