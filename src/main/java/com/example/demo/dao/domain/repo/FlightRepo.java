package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.FlightEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepo extends CrudRepository<FlightEntity, Long> {

    List<FlightEntity> findAllByDateArrival(LocalDateTime dateArrival);
    List<FlightEntity> findAllByDateDepartment(LocalDateTime dateDepartment);
    List<FlightEntity> findAllByDateArrivalBetween(LocalDateTime start, LocalDateTime end);
    List<FlightEntity> findAllByDateDepartmentBetween(LocalDateTime start, LocalDateTime end);

}
