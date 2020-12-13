package com.example.demo.dao.domain.dto;

import com.example.demo.dao.domain.base.BaseDto;
import com.example.demo.dao.domain.schema.jsonb.BillData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BillDto extends BaseDto {

    private BillData billDate;
    private boolean approve;
    private UserDto user;
    private TourDto tour;

}
