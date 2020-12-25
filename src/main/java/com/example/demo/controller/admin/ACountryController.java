package com.example.demo.controller.admin;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.model.CountryEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.CountryService;
import com.example.demo.service.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/country")
@RequiredArgsConstructor
public class ACountryController {

    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @PostMapping("/add")
    public ResponseEntity<String> addNewCountry(@RequestBody CountryDto dto) {
        try {
            countryService.create(dto);
            return new ResponseEntity<>(
                    "Country successfull added",
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteCountry(@RequestParam String countryName) {

        try {

            CountryEntity byName = countryService.findByName(countryName);
            countryService.delete(byName);

            return new ResponseEntity<>(
                    "Country with name: " + countryName + " successful deleted",
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
