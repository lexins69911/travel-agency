package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.jsonb.RoomData;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@TypeDefs({
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@NoArgsConstructor
public class RoomEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_size")
    private int roomSize;

    @Column(name = "category")
    private String category;

    @Column(name = "count")
    private int count;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private RoomData roomData;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;
}
