package com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.Entity;

import java.time.LocalDate;

public class Client implements Entity {
    private String name;
    private String surname;
    private String patronymic;
    private String passportId;
    private LocalDate dateOfBirth;
    private Address address;
    private String email;
}
