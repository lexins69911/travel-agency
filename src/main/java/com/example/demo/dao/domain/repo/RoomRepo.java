package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.RoomEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepo extends CrudRepository<RoomEntity, Long> {
}
