package com.example.demo.controller.admin;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/tour")
@RequiredArgsConstructor
public class ATourController {

    private final TourService tourService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewTour(@RequestBody TourDto tourDto) {

        try {
            TourEntity tourEntity = tourService.create(tourDto);
            return new ResponseEntity<>(
                    "Add new tour",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    "Something wrong",
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteTour(@PathVariable("id") Long tourId) {

        try {
            TourEntity byId = tourService.findById(tourId);
            tourService.delete(byId);
            return new ResponseEntity<>(
                    "Successful deleted",
                    HttpStatus.OK
            );
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
