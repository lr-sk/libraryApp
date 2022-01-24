package com.ita.u1.skomorokhova.libraryApp.domain;

import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Image;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Book {
    private long id;
    private String name;
    private String originalName;
    private List<Genre> genres;
    private List<Author> authors;
    private BigDecimal cost;
    private BigDecimal costPerDay;
    private int yearOfPublishing;
    private int numberOfPages;
    private int numberOfCopies;
    @Builder.Default private LocalDate registrationDate = LocalDate.now();
    private List<Image> images;
}
