package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.enums.RoomCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Integer roomSize;
    private RoomCategory category;
    private Integer freeCount;

}
