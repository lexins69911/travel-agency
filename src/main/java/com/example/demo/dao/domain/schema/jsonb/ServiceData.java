package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.ServiceCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class ServiceData {

    private BigInteger price;
    private ServiceCategory category;
    private String description;

}
