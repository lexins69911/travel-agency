package com.example.demo.service;

import com.example.demo.dao.domain.dto.CountryDto;
import com.example.demo.dao.domain.dto.HotelDto;
import com.example.demo.dao.domain.dto.UserDto;
import com.example.demo.dao.domain.model.*;
import com.example.demo.dao.domain.schema.enums.HotelStars;
import com.example.demo.dao.domain.schema.enums.Role;
import com.example.demo.dao.domain.schema.enums.RoomCategory;
import com.example.demo.dao.domain.schema.enums.ServiceCategory;
import com.example.demo.dao.domain.schema.jsonb.CountryData;
import com.example.demo.dao.domain.schema.jsonb.HotelData;
import com.example.demo.dao.domain.schema.jsonb.Room;
import com.example.demo.dao.domain.schema.jsonb.ServiceData;
import com.example.demo.service.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduledService {

    private final UserService userService;
    private final CountryService countryService;
    private final HotelService hotelService;
    private final ServicesService servicesService;
    private final TourService tourService;

    @Scheduled(fixedDelay = 24*60*60*1000)
    public void scheduled() {

        UserDto userDto = new UserDto();

        userDto.setLogin("admin");
        userDto.setPassword("Supersexy");
        userDto.setRole(Role.ROLE_ADMIN);

        UserEntity userEntity = userService.create(userDto);

        CountryData countryData = new CountryData();
        countryData.setEN("RUSSIA");
        countryData.setRUS("РОССИЯ");

        CountryDto countryDto = new CountryDto();
        countryDto.setName("Russia");
        countryDto.setCountryData(countryData);

        CountryEntity countryEntity = countryService.create(countryDto);

        List<Room> roomList = Arrays.asList(
                new Room(2, RoomCategory.LOWCOST, 15),
                new Room(4, RoomCategory.MIDLECOST, 10),
                new Room(2, RoomCategory.ELITE, 1)
        );


        HotelData hotelData = new HotelData();
        hotelData.setStars(HotelStars.FIVE);

        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName("Continental");
        hotelEntity.setCountryEntity(countryEntity);
        hotelEntity.setHotelData(hotelData);
        hotelEntity.setRoomList(roomList);

        HotelEntity save = hotelService.save(hotelEntity);

        ServiceData serviceData = new ServiceData();
        serviceData.setCategory(ServiceCategory.Medicine);
        serviceData.setDescription("Самый лучший в мире тайский массаж");
        serviceData.setPrice(new BigInteger("3000"));

        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setName("Тайский массаж");
        serviceEntity.setServiceData(serviceData);

        ServiceEntity saved = servicesService.save(serviceEntity);

        ServiceData serviceData1 = new ServiceData();
        serviceData.setCategory(ServiceCategory.Medicine);
        serviceData.setDescription("Описание отсутствует");
        serviceData.setPrice(new BigInteger("321"));

        ServiceEntity serviceEntity1 = new ServiceEntity();
        serviceEntity1.setName("Иглоукалываение");
        serviceEntity1.setServiceData(serviceData);

        ServiceEntity saved2 = servicesService.save(serviceEntity1);

        Set<ServiceEntity> services = new HashSet<>();
        services.add(saved);
        services.add(saved2);

        TourEntity tourEntity = new TourEntity();
        tourEntity.setHotelEntity(save);
        tourEntity.setServices(services);
        tourEntity.setName("Best world tour");

        tourService.save(tourEntity);

    }
}
