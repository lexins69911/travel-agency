package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.enums.ServiceCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
public class Services {

    private String name;
    private BigInteger price;
    private ServiceCategory category;
    private String description;

}
