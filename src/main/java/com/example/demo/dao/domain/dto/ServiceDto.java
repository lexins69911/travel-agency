package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.ServiceData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class ServiceDto {

    private String name;
    private BigInteger price;
    private String category;
    private String description;
    private ServiceData serviceData;
    private TourDto tour;

}
