package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.jsonb.Services;
import com.example.demo.dao.domain.schema.jsonb.TourData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tour")
@Getter
@Setter
@NoArgsConstructor
public class TourEntity extends BaseEntity {

    @Column(name = "tour_name")
    private String name;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private TourData tourData;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;

    @OneToOne(mappedBy = "tour")
    private BillEntity bill;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Services> services;

}
