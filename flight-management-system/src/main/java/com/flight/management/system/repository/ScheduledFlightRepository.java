package com.flight.management.system.repository;

import com.flight.management.system.model.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduledFlightRepository extends JpaRepository<ScheduledFlight, Long> {
    List<ScheduledFlight> findByFlightId(Long flightId);

    List<ScheduledFlight> findByScheduleId(Long scheduleId);
}
