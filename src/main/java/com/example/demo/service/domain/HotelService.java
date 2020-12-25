package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.dao.domain.model.HotelEntity;
import com.example.demo.dao.domain.repo.HotelRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService implements BaseService<HotelEntity, HotelDto> {

    private final HotelRepo hotelRepo;
    private final HotelMapper hotelMapper;

    public List<HotelDto> findByCountryName(String name) {
        List<HotelEntity> allByCountryEntityName = hotelRepo.findAllByCountryEntityName(name);
        return hotelMapper.toListDto(allByCountryEntityName);
    }

    public List<HotelEntity> findAllByName (String name) {
        return hotelRepo.findAllByName(name);
    }

    public List<HotelDto> findAllByPartOfName(String part) {
        List<HotelEntity> allByNameContains = hotelRepo.findAllByNameContains(part);
        return hotelMapper.toListDto(allByNameContains);
    }

    @Override
    public HotelEntity create(HotelDto dto) {
        HotelEntity hotelEntity = hotelMapper.toEntity(dto);
        return hotelRepo.save(hotelEntity);
    }

    @Override
    public HotelEntity save(HotelEntity entity) {
        return hotelRepo.save(entity);
    }

    @Override
    public void delete(HotelEntity entity) {
        hotelRepo.delete(entity);
    }

    @Override
    public boolean isExist(HotelEntity entity) {
        try {
            if (entity.getId()!=null) {
                findById(entity.getId());
                return true;
            }
            if (!entity.getName().isEmpty()) {
                List<HotelEntity> allByName = findAllByName(entity.getName());
                return !allByName.isEmpty();
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data: id and name");
    }

    @Override
    public HotelEntity findById(Long id) {
        Optional<HotelEntity> byId = hotelRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find Hotel with id: " + id);
    }

    @Override
    public List<HotelEntity> findAll() {
        return (List<HotelEntity>) hotelRepo.findAll();
    }
}
