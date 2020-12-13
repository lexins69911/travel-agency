package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import com.example.demo.dao.domain.repo.TourRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourService implements BaseService<TourEntity, TourDto> {

    private final TourRepo tourRepo;
    private final TourMapper mapper;

    public List<TourEntity> findAllByDateStart (LocalDate start) {
        return tourRepo.findAllByDateStart(start);
    }

    public List<TourEntity> findAllByDateEnd (LocalDate end) {
        return tourRepo.findAllByDateEnd(end);
    }

    public List<TourEntity> findAllTourWithDateBetween(LocalDate start, LocalDate end) {
        return tourRepo.findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual(start, end);
    }

    @Override
    public TourEntity create(TourDto dto) {
        TourEntity tourEntity = mapper.toEntity(dto);
        return tourRepo.save(tourEntity);
    }

    @Override
    public TourEntity save(TourEntity entity) {
        return tourRepo.save(entity);
    }

    @Override
    public void delete(TourEntity entity) {
        tourRepo.delete(entity);
    }

    @Override
    public boolean isExist(TourEntity entity) {
        try {
            if (entity.getId()!=null) {
                tourRepo.findById(entity.getId());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data: id");
    }

    @Override
    public TourEntity findById(Long id) {
        Optional<TourEntity> byId = tourRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find tour by id: " + id);
    }

    @Override
    public List<TourEntity> findAll() {
        return (List<TourEntity>) tourRepo.findAll();
    }
}
