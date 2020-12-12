package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.HotelEntity;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepo extends CrudRepository<HotelEntity, Long> {
}
