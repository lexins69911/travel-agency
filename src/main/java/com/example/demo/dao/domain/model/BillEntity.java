package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "bill")
@Getter
@Setter
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

    @Lob
    @Column(name = "bill_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] flightDate;

}
