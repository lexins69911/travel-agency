package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Getter
@Setter
@NoArgsConstructor
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tourEntity;

    @Column(name = "date_arrival")
    private LocalDateTime dateArrival;

    @Column(name = "date_department")
    private LocalDateTime dateDepartment;

    @Lob
    @Column(name = "flight_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] flightDate;

}
