package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.RoomEntity;
import com.example.demo.dao.domain.schema.RoomCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoomRepo extends CrudRepository<RoomEntity, Long> {

    List<RoomEntity> findAllByCategory (RoomCategory category);
    List<RoomEntity> findAllByRoomSizeGreaterThanEqualAndRoomSizeLessThanEqual(int greater, int less);
    List<RoomEntity> findAllByRoomSizeGreaterThanEqual (int roomSize);
    List<RoomEntity> findAllByRoomSizeLessThanEqual (int roomSize);
    List<RoomEntity> findAllByRoomSize(int roomSize);

}
