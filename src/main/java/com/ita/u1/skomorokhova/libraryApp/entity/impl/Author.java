package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Author implements Entity {
    private long id;
    private String name;
    private String surname;
    private String patronymic;
    private String image;
    private String fullName;
}
