package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.model.CountryEntity;
import com.example.demo.dao.domain.repo.CountryRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryService implements BaseService<CountryEntity, CountryDto> {

    private final CountryRepo countryRepo;
    private final CountryMapper countryMapper;

    public CountryEntity findByName(String name) {
        Optional<CountryEntity> byName = countryRepo.findByName(name);
        if (byName.isPresent()) {
            return byName.get();
        } else
            throw new EntityNotFoundException("Can't find country with name: " + name);
    }

    @Override
    public CountryEntity create(CountryDto dto) {
        CountryEntity countryEntity = countryMapper.toEntity(dto);
        return countryRepo.save(countryEntity);
    }

    @Override
    public CountryEntity save(CountryEntity entity) {
        return countryRepo.save(entity);
    }

    @Override
    public void delete(CountryEntity entity) {
        countryRepo.delete(entity);
    }

    @Override
    public boolean isExist(CountryEntity entity) {
        try {
            if (entity.getId()!=null) {
                findById(entity.getId());
                return true;
            }
            if (!entity.getName().isEmpty()){
                findByName(entity.getName());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data: id and name");
    }

    @Override
    public CountryEntity findById(Long id) {
        Optional<CountryEntity> byId = countryRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find country with id: " + id);
    }

    @Override
    public List<CountryEntity> findAll() {
        return (List<CountryEntity>) countryRepo.findAll();
    }
}
