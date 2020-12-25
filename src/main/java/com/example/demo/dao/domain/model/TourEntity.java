package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.jsonb.TourData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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

    @Column(name = "count")
    private int count;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private TourData tourData;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

    @OneToOne(mappedBy = "tour")
    private BillEntity bill;

    @OneToMany(
            mappedBy = "tour",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<ServiceEntity> services;

}
