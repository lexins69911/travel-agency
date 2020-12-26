package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.ServiceDto;
import com.example.demo.dao.domain.model.ServiceEntity;
import com.example.demo.dao.domain.repo.ServiceRepo;
import com.example.demo.dao.domain.schema.enums.ServiceCategory;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.ServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicesService implements BaseService<ServiceEntity, ServiceDto> {

    private final ServiceRepo serviceRepo;
    private final ServiceMapper serviceMapper;

    @Override
    public ServiceEntity create(ServiceDto dto) {
        ServiceEntity serviceEntity = serviceMapper.toEntity(dto);
        return serviceRepo.save(serviceEntity);
    }

    @Override
    public ServiceEntity save(ServiceEntity entity) {
        return serviceRepo.save(entity);
    }

    @Override
    public void delete(ServiceEntity entity) {
        serviceRepo.delete(entity);
    }

    @Override
    public boolean isExist(ServiceEntity entity) {
        try {
            if (entity.getId()!=null) {
                findById(entity.getId());
                return true;
            }
        } catch (EntityNotFoundException e) {
            return false;
        }
        throw new InsufficientDataException("Insufficient data");
    }

    @Override
    public ServiceEntity findById(Long id) {
        Optional<ServiceEntity> byId = serviceRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find Service by id: " + id);
    }

    @Override
    public List<ServiceEntity> findAll() {
        return (List<ServiceEntity>) serviceRepo.findAll();
    }

}
