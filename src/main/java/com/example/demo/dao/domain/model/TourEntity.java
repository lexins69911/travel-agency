package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tour")
@Getter
@Setter
@NoArgsConstructor
public class TourEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @Column(name = "count")
    private int count;

    @Lob
    @Column(name = "tour_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] tourDate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;

}
