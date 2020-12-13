package com.example.demo.service.domain;

import com.example.demo.dao.domain.dto.BillDto;
import com.example.demo.dao.domain.model.BillEntity;
import com.example.demo.dao.domain.repo.BillRepo;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.exception.InsufficientDataException;
import com.example.demo.service.base.BaseService;
import com.example.demo.service.mapper.BillMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillService implements BaseService<BillEntity, BillDto> {

    private final BillRepo billRepo;
    private final BillMapper billMapper;

    public List<BillEntity> findByTourId(Long id) {
        return billRepo.findByTourId(id);
    }

    @Override
    public BillEntity create(BillDto dto) {
        BillEntity billEntity = billMapper.toEntity(dto);
        return billRepo.save(billEntity);
    }

    @Override
    public BillEntity save(BillEntity entity) {
        return billRepo.save(entity);
    }

    @Override
    public void delete(BillEntity entity) {
        billRepo.delete(entity);
    }

    @Override
    public boolean isExist(BillEntity entity) {
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
    public BillEntity findById(Long id) {
        Optional<BillEntity> byId = billRepo.findById(id);
        if (byId.isPresent())
            return byId.get();
        else
            throw new EntityNotFoundException("Can't find bill by id: " + id);
    }

    @Override
    public List<BillEntity> findAll() {
        return (List<BillEntity>) billRepo.findAll();
    }
}
