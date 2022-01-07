package com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Genre;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.EntityService;

import java.util.Arrays;
import java.util.List;

public class GenresService implements EntityService<Genre> {
    @Override
    public List getAll() {
        return Arrays.asList(Genre.values());
    }
}
