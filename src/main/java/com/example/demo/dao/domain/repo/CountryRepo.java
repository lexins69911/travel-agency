package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.CountryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CountryRepo extends CrudRepository<CountryEntity, Long> {

    Optional<CountryEntity> findByName (String name);
}
