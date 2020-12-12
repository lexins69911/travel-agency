package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tourEntity;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "service_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] serviceData;

}
