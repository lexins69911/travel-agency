package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepo extends CrudRepository<ServiceEntity, Long> {


}
