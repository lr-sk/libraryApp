package com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.Entity;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
public class Book implements Entity {
    private int id;
    private String name;
    private String originalName;
    //private List<Genre> genres = new ArrayList<>();
    private BigDecimal cost;
    private BigDecimal costPerDay;
    //private List<Author> authors = new ArrayList<>();
    private int yearOfPublishing;
    private int numberOfPages;
    private int numberOfCopies;
    @Builder.Default private LocalDate registrationDate = LocalDate.now();
    private File image;
}
