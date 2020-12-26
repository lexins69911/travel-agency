package com.example.demo.dao.domain.repo;

import com.example.demo.dao.domain.model.TourEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TourRepo extends CrudRepository<TourEntity, Long> {

    List<TourEntity> findAllByDateStartGreaterThanEqual (LocalDate dateStart);
    List<TourEntity> findAllByDateEndLessThanEqual (LocalDate dateEnd);
    List<TourEntity> findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual (LocalDate start, LocalDate end);
    List<TourEntity> findAllByNameContains(String partName);
    Optional<TourEntity> findByHotelId(Long hotelId);

}
