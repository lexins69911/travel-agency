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
@NoArgsConstructor
public class ServiceEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private TourEntity tour;

    @Column(name = "name")
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private ServiceData serviceData;

}
