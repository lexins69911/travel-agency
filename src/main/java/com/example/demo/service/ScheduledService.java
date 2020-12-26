package com.example.demo.service;

import com.example.demo.dao.domain.dto.*;
import com.example.demo.dao.domain.model.*;
import com.example.demo.dao.domain.schema.enums.HotelStars;
import com.example.demo.dao.domain.schema.enums.Role;
import com.example.demo.dao.domain.schema.enums.RoomCategory;
import com.example.demo.dao.domain.schema.enums.ServiceCategory;
import com.example.demo.dao.domain.schema.jsonb.*;
import com.example.demo.service.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

@Log
@Service
@RequiredArgsConstructor
public class ScheduledService {

    private final UserService userService;
    private final CountryService countryService;
    private final HotelService hotelService;
    private final TourService tourService;

    @Scheduled(fixedDelay = 24*60*60*1000)
    public void scheduled() {
        log.info("end scheduling");
    }
}

/*


        try {
            UserDto admin = new UserDto();

            admin.setLogin("admin");
            admin.setPassword("admin");
            admin.setRole(Role.ROLE_ADMIN);

            UserDto userDto = new UserDto();
            userDto.setLogin("testUser");
            userDto.setPassword("testPassword");
            userDto.setRole(Role.ROLE_USER);

            UserEntity adminUser = userService.create(admin);
            UserEntity testUser = userService.create(userDto);

            CountryData russiaData = new CountryData();
            russiaData.setEN("RUSSIA");
            russiaData.setRUS("РОССИЯ");

            CountryData egyptData = new CountryData();
            egyptData.setRUS("ЕГИПЕТ");
            egyptData.setEN("EGYPT");

            CountryData canadaData = new CountryData();
            canadaData.setRUS("КАНАДА");
            canadaData.setEN("CANADA");

            CountryDto russia = new CountryDto();
            russia.setName("Russia");
            russia.setCountryData(russiaData);

            CountryDto egypt = new CountryDto();
            egypt.setName("Canada");
            egypt.setCountryData(egyptData);

            CountryDto canada = new CountryDto();
            canada.setName("Канада");
            canada.setCountryData(canadaData);

            CountryEntity russiaEntity = countryService.create(russia);
            CountryEntity egyptEntity = countryService.create(egypt);
            CountryEntity canadaEntity = countryService.create(canada);

            List<Room> roomList = Arrays.asList(
                    new Room(2, RoomCategory.LOWCOST, 15),
                    new Room(4, RoomCategory.MIDLECOST, 10),
                    new Room(2, RoomCategory.ELITE, 1)
            );

            List<Room> roomList2 = Arrays.asList(
                    new Room(3, RoomCategory.MIDLECOST, 7),
                    new Room(5, RoomCategory.LOWCOST, 12),
                    new Room(1, RoomCategory.HIGHCOST, 4),
                    new Room(6, RoomCategory.LOWCOST, 3)
            );

            List<Room> roomList3 = Arrays.asList(
                    new Room(1, RoomCategory.HIGHCOST, 10),
                    new Room(2, RoomCategory.MIDLECOST, 24),
                    new Room(4, RoomCategory.MIDLECOST, 34)
            );

            HotelData fiveStar = new HotelData();
            fiveStar.setStars(HotelStars.FIVE);

            HotelData fourStar = new HotelData();
            fourStar.setStars(HotelStars.FOUR);

            HotelData threeStar = new HotelData();
            threeStar.setStars(HotelStars.THREE);


            HotelEntity continentalDto = new HotelEntity();
            continentalDto.setName("Continental");
            continentalDto.setHotelData(fiveStar);
            continentalDto.setRoomList(roomList);
            continentalDto.setCountry(egyptEntity);

            HotelEntity marusyaDto = new HotelEntity();
            marusyaDto.setName("ОТЕЛЬ-МАРИНА");
            marusyaDto.setHotelData(fourStar);
            marusyaDto.setRoomList(roomList2);
            marusyaDto.setCountry(russiaEntity);

            HotelEntity trivagoDto = new HotelEntity();
            trivagoDto.setName("To-o-oronto");
            trivagoDto.setHotelData(threeStar);
            trivagoDto.setRoomList(roomList2);
            trivagoDto.setCountry(canadaEntity);

            HotelEntity continentalEntity = hotelService.save(continentalDto);
            HotelEntity marusyaEntity = hotelService.save(marusyaDto);
            HotelEntity trivageEntity = hotelService.save(trivagoDto);

            List<Services> services = Arrays.asList(
                    new Services("Тайский массаж",
                            new BigInteger("300"),
                            ServiceCategory.Medicine,
                            "Лучший в мире тайский массаж"),
                    new Services("Трансферт до отеля",
                            new BigInteger("0"),
                            ServiceCategory.Transportation,
                            "Доставки из аэропорта в отель")
            );

            LocalDate start = LocalDate.now().plusDays(5);
            LocalDate end = LocalDate.now().plusDays(12);

            TourEntity tourEntity = new TourEntity();
            tourEntity.setDateStart(start);
            tourEntity.setDateEnd(end);
            tourEntity.setHotel(continentalEntity);
            tourEntity.setServices(services);
            tourEntity.setName("Best world tour");
            TourEntity save = tourService.save(tourEntity);

            TourEntity tourEntity1 = new TourEntity();
            tourEntity1.setDateStart(start.plusDays(12));
            tourEntity1.setDateEnd(end.plusDays(14));
            tourEntity1.setHotel(marusyaEntity);
            tourEntity1.setServices(services);
            tourEntity1.setName("Russian GLUBINKA tour");
            TourEntity save1 = tourService.save(tourEntity1);

            TourEntity tourEntity2 = new TourEntity();
            tourEntity2.setDateStart(start.plusDays(30));
            tourEntity2.setDateEnd(end.plusDays(36));
            tourEntity2.setHotel(trivageEntity);
            tourEntity2.setServices(services);
            tourEntity2.setName("Canada's tour");
            TourEntity save2 = tourService.save(tourEntity2);

        } catch (Exception e) {
            e.printStackTrace();
        }


 */