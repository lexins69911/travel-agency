package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.TourEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface TourRepo extends CrudRepository<TourEntity, Long> {

    List<TourEntity> findAllByDateStart (LocalDate dateStart);
    List<TourEntity> findAllByDateEnd (LocalDate dateEnd);
    List<TourEntity> findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual (LocalDate start, LocalDate end);
    List<TourEntity> findAllByNameContains(String partName);

}
