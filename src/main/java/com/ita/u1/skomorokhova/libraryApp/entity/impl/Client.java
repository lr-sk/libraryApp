package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class Client implements Entity {
    private Long id;
    private String name;
    private String surname;
    private String patronymic;
    private String passportId;
    private LocalDate dateOfBirth;
    private Address address;
    private String email;
}
