package com.flight.management.system.repository;

import com.flight.management.system.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findBySourceAirportAndDestinationAirport(String source, String destination);
}