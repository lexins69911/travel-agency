package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.HotelEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepo extends CrudRepository<HotelEntity, Long> {

    List<HotelEntity> findAllByName (String name);
    List<HotelEntity> findAllByNameContains(String partOfName);
    List<HotelEntity> findAllByCountryEntityName(String name);
}
