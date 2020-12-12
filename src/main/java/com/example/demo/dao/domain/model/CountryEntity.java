package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Getter
@Setter
@NoArgsConstructor
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "country_name")
    private String name;

    @Lob
    @Column(name = "country_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] countryData;

}
