package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.schema.BillData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDto {

    private BillData billDate;
    private boolean approve;
    private UserDto user;
    private TourDto tour;

}
