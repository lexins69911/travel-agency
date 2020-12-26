package com.example.demo.dao.domain.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
}
