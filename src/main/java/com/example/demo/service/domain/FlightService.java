package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.FlightDto;
import com.example.demo.dao.domain.model.FlightEntity;
import com.example.demo.dao.domain.repo.FlightRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.FlightMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService implements BaseService<FlightEntity, FlightDto> {

    private final FlightRepo flightRepo;
    private final FlightMapper flightMapper;

    public List<FlightEntity> findAllByDateArrival(LocalDateTime arrival) {
        return flightRepo.findAllByDateArrival(arrival);
    }

    public List<FlightEntity> findAllByDateDepartment(LocalDateTime department) {
        return flightRepo.findAllByDateDepartment(department);
    }

    public List<FlightEntity> findAllByDateArrivalBetween(LocalDateTime start, LocalDateTime end) {
        return flightRepo.findAllByDateArrivalBetween(start, end);
    }

    public List<FlightEntity> findAllByDateDepartmentBetween(LocalDateTime start, LocalDateTime end) {
        return flightRepo.findAllByDateDepartmentBetween(start, end);
    }

    @Override
    public FlightEntity create(FlightDto dto) {
        FlightEntity flightEntity = flightMapper.toEntity(dto);
        return flightRepo.save(flightEntity);
    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return flightRepo.save(entity);
    }

    @Override
    public void delete(FlightEntity entity) {
        flightRepo.delete(entity);
    }

    @Override
    public boolean isExist(FlightEntity entity) {
        try {
            if (entity.getId()!=null){
                findById(entity.getId());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data: id");
    }

    @Override
    public FlightEntity findById(Long id) {
        Optional<FlightEntity> byId = flightRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find flight with id: " + id);
    }

    @Override
    public List<FlightEntity> findAll() {
        return (List<FlightEntity>) flightRepo.findAll();
    }
}
