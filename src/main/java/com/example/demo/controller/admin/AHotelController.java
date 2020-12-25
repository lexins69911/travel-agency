package com.example.demo.controller.admin;

import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.service.domain.HotelService;
import com.example.demo.service.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/hotel")
@RequiredArgsConstructor
public class AHotelController {

    private final HotelService hotelService;
    private final HotelMapper hotelMapper;

    @PostMapping("/add")
    public ResponseEntity<String> addNewHotel(@RequestBody HotelDto dto) {

        try {
            hotelService.create(dto);

            return new ResponseEntity<>(
                    "Hotel successful added",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}
