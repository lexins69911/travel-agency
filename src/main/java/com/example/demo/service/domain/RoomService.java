package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.RoomDto;
import com.example.demo.dao.domain.model.RoomEntity;
import com.example.demo.dao.domain.repo.RoomRepo;
import com.example.demo.dao.domain.schema.RoomCategory;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.RoomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService implements BaseService<RoomEntity, RoomDto> {

    private final RoomRepo roomRepo;
    private final RoomMapper roomMapper;

    public List<RoomEntity> findAllByRoomCategory(RoomCategory category) {
        return roomRepo.findAllByCategory(category);
    }

    public List<RoomEntity> finAllRoomWithRoomSizeMoreThan(Integer roomSize) {
        return roomRepo.findAllByRoomSizeGreaterThanEqual(roomSize);
    }

    public List<RoomEntity> findAllRoomWithRoomSizeLessThan(Integer roomSize) {
        return roomRepo.findAllByRoomSizeLessThanEqual(roomSize);
    }

    public List<RoomEntity> finAllRoomWithRoomSizeBetween(Integer start, Integer end) {
        List<RoomEntity> result =
                roomRepo.findAllByRoomSizeGreaterThanEqualAndRoomSizeLessThanEqual(start, end);
        return result;
    }

    public List<RoomEntity> findAllRoomByRoomSize (Integer roomSize) {
        return roomRepo.findAllByRoomSize(roomSize);
    }

    @Override
    public RoomEntity create(RoomDto dto) {
        RoomEntity roomEntity = roomMapper.toEntity(dto);
        return roomRepo.save(roomEntity);
    }

    @Override
    public RoomEntity save(RoomEntity entity) {
        return roomRepo.save(entity);
    }

    @Override
    public void delete(RoomEntity entity) {
        roomRepo.delete(entity);
    }

    @Override
    public boolean isExist(RoomEntity entity) {
        try {
            if (entity.getId()!=null) {
                findById(entity.getId());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data: id");
    }

    @Override
    public RoomEntity findById(Long id) {
        Optional<RoomEntity> byId = roomRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find room by id: " + id);
    }

    @Override
    public List<RoomEntity> findAll() {
        return (List<RoomEntity>) roomRepo.findAll();
    }
}
