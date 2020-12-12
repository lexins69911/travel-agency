package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {
}
