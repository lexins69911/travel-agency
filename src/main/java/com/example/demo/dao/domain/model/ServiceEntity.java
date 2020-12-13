package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.ServiceCategory;
import com.example.demo.dao.domain.schema.jsonb.ServiceData;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "service")
@Getter
@Setter
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
public class ServiceEntity extends BaseEntity {

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
    private ServiceCategory category;

    @Column(name = "description")
    private String description;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ServiceData serviceData;

}
