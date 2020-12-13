package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.ServiceEntity;
import com.example.demo.dao.domain.schema.ServiceCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServiceRepo extends CrudRepository<ServiceEntity, Long> {

    List<ServiceEntity> findAllByCategory(ServiceCategory category);
}
