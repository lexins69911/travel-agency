package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "hotel_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] hotelData;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

}
