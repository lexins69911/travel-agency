package com.example.demo.dao.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDto {

    private byte[] billDate;
    private boolean approve;
    private UserDto user;
    private TourDto tour;

}
