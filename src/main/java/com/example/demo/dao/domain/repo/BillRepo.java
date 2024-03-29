package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.BillEntity;
import com.example.demo.dao.domain.model.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepo extends CrudRepository<BillEntity, Long> {

    List<BillEntity> findByTourId (Long id);
    List<BillEntity> findAllByUser (UserEntity userEntity);

}
