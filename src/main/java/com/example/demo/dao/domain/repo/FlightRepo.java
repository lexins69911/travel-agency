package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.FlightEntity;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepo extends CrudRepository<FlightEntity, Long> {
}
