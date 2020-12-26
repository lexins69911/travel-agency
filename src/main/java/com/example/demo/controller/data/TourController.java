package com.example.demo.controller.data;

import com.example.demo.dao.domain.dto.TourDto;
import com.example.demo.dao.domain.model.TourEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.HotelService;
import com.example.demo.service.domain.TourService;
import com.example.demo.service.mapper.TourMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/get")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;
    private final TourMapper tourMapper;
    private final HotelService hotelService;

    @GetMapping("/tour/{id}")
    public ResponseEntity<TourDto> getTourById(@PathVariable("id") Long id) {
        try {

            TourEntity byId = tourService.findById(id);
            return new ResponseEntity<>(
                    tourMapper.toDto(byId),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/tour")
    public ResponseEntity<List<TourDto>> getTourByPartName(@RequestParam("tour_name") String tourName) {
        List<TourDto> allByPartName = tourService.findAllByPartName(tourName);
        if (allByPartName.isEmpty())
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        return new ResponseEntity<>(
                allByPartName,
                HttpStatus.OK
        );
    }

    @GetMapping("/tour/all")
    public ResponseEntity<List<TourDto>> getAllTours() {

        List<TourEntity> all = tourService.findAll();
        return new ResponseEntity<>(
                tourMapper.toListDto(all),
                HttpStatus.OK
        );

    }

    @GetMapping("/tour/by/date")
    public ResponseEntity<List<TourDto>> getToursByDatetime(
            @RequestParam(name = "start_date", required = false)LocalDate start,
            @RequestParam(name = "end_date", required = false) LocalDate end) {

        if (start==null && end==null) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }

        if (start!=null && end!=null) {
            List<TourDto> allTourWithDateBetween = tourService.findAllTourWithDateBetween(start, end);
            return new ResponseEntity<>(
                    allTourWithDateBetween,
                    HttpStatus.OK
            );
        }

        if (start!=null) {
            List<TourDto> allByDateStart = tourService.findAllByDateStart(start);
            return new ResponseEntity<>(
                    allByDateStart,
                    HttpStatus.OK
            );
        }

        List<TourDto> allByDateEnd = tourService.findAllByDateEnd(end);
        return new ResponseEntity<>(
                allByDateEnd,
                HttpStatus.OK
        );

    }

    @GetMapping("/tour/by/hotel")
    public ResponseEntity<TourDto> getTourByHotelId(@RequestParam("hotel_id") Long hotelId) {

        try {
            TourDto byHotelId = tourService.findByHotelId(hotelId);

            return new ResponseEntity<>(
                    byHotelId,
                    HttpStatus.OK
            );
        } catch ( EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
