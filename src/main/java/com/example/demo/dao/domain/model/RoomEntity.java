package com.example.demo.dao.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "room")
@Getter
@Setter
@NoArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_size")
    private int roomSize;

    @Column(name = "category")
    private String category;

    @Column(name = "count")
    private int count;

    @Lob
    @Column(name = "room_data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] roomData;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotelEntity;
}
