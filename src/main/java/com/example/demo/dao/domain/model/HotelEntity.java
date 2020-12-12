package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.schema.HotelData;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private HotelData hotelData;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

}
