package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.RoomCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class Room {

    private Integer roomSize;
    private RoomCategory category;
    private Integer freeCount;

}
