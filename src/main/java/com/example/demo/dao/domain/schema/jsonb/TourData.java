package com.example.demo.dao.domain.schema.jsonb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class TourData implements Serializable {

    private LocalDateTime dateArrival;
    private LocalDateTime dateDepartment;

}
