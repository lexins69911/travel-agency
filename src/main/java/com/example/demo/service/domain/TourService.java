package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import com.example.demo.dao.domain.repo.TourRepo;
import com.example.demo.dao.domain.schema.jsonb.HotelData;
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

    public TourDto findByHotelId(Long hotelId) {

        Optional<TourEntity> byHotelId = tourRepo.findByHotelId(hotelId);
        if (byHotelId.isPresent())
            return mapper.toDto(byHotelId.get());
        else
            throw new EntityNotFoundException("Can't find tour by hotel id: " + hotelId);
    }

    public List<TourDto> findAllByPartName(String name) {
        List<TourEntity> allByNameContains = tourRepo.findAllByNameContains(name);
        return mapper.toListDto(allByNameContains);
    }

    public List<TourDto> findAllByDateStart (LocalDate start) {
        List<TourEntity> allByDateStart = tourRepo.findAllByDateStart(start);
        return mapper.toListDto(allByDateStart);
    }

    public List<TourDto> findAllByDateEnd (LocalDate end) {
        List<TourEntity> allByDateEnd = tourRepo.findAllByDateEnd(end);
        return mapper.toListDto(allByDateEnd);
    }

    public List<TourDto> findAllTourWithDateBetween(LocalDate start, LocalDate end) {
        List<TourEntity> all = tourRepo.findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual(start, end);
        return mapper.toListDto(all);
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
