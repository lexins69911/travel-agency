package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.enums.ServiceCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class ServiceData {

    private BigInteger price;
    private ServiceCategory category;
    private String description;

}
