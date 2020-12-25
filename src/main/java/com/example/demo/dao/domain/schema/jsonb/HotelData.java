package com.example.demo.dao.domain.schema.jsonb;

import com.example.demo.dao.domain.schema.enums.HotelStars;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class HotelData implements Serializable {

    private HotelStars stars;
}
