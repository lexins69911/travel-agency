package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.schema.FlightData;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flight")
@Getter
@Setter
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
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

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private FlightData flightDate;

}
