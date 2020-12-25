package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.jsonb.HotelData;
import com.example.demo.dao.domain.schema.jsonb.Room;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
public class HotelEntity extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Room> roomList;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private HotelData hotelData;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

}
