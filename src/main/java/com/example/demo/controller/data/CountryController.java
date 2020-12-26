package com.example.demo.controller.data;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.model.CountryEntity;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.service.domain.CountryService;
import com.example.demo.service.mapper.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/get")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;
    private final CountryMapper countryMapper;


    @GetMapping("/country/{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable("id") Long id) {

        try {
            CountryEntity byId = countryService.findById(id);
            return new ResponseEntity<>(
                    countryMapper.toDto(byId),
                    HttpStatus.OK
            );
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/country")
    public ResponseEntity<CountryDto> getCountryByName(@RequestParam("country_name") String countryName) {

        try {
            CountryEntity byName = countryService.findByName(countryName);

            return new ResponseEntity<>(
                    countryMapper.toDto(byName),
                    HttpStatus.OK
            );
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping("/country/all")
    public ResponseEntity<List<CountryDto>> getAllCountry() {

        List<CountryEntity> all = countryService.findAll();
        return new ResponseEntity<>(
                countryMapper.toListDto(all),
                HttpStatus.OK
        );
    }

}
