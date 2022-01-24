package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Book implements Entity {
    long id;
    String name;
    String originalName;
    List<Genre> genres;
    List<Author> authors;
    BigDecimal cost;
    BigDecimal costPerDay;
    int yearOfPublishing;
    int numberOfPages;
    int numberOfCopies;
    @Builder.Default LocalDate registrationDate = LocalDate.now();
    List<Image> images;
}
