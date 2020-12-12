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

@Entity
@Table(name = "bill")
@Getter
@Setter
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @Column(name = "approve")
    private boolean approve;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private FlightData flightDate;

}
