package com.example.demo.dao.domain.dto;

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
    private byte[] serviceData;
    private TourDto tour;

}
