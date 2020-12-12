package com.example.demo.service.base;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.base.BaseEntity;

import java.util.List;

public interface BaseService<E extends BaseEntity, D extends BaseDto> {

    E create(D dto);
    E save(E entity);
    void delete(E entity);
    boolean isExist(E entity);
    E findById(Long id);
    List<E> findAll();

}
