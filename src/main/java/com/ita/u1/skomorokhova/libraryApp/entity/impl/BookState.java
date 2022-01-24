package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookState implements Entity {
    private long id;
    private String name;
    private BigDecimal fineFactor;

}
