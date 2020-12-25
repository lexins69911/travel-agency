package com.example.demo.controller.data;

import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.service.domain.HotelService;
import com.example.demo.service.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/get")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @GetMapping("/hotel")
    public ResponseEntity<List<HotelDto>> getHotelsByName(@RequestParam("name") String hotelName) {

        List<HotelDto> allByPartOfName = hotelService.findAllByPartOfName(hotelName);

        if (allByPartOfName.isEmpty())
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );

        return new ResponseEntity<>(
                allByPartOfName,
                HttpStatus.OK
        );

    }

    @GetMapping("/hotel/by/country")
    public ResponseEntity<List<HotelDto>> getHotelsByCountry(@RequestParam("country_name") String countryName) {

        List<HotelDto> byCountryName = hotelService.findByCountryName(countryName);
        if (byCountryName.isEmpty())
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        return new ResponseEntity<>(
                byCountryName,
                HttpStatus.OK
        );
    }
}
