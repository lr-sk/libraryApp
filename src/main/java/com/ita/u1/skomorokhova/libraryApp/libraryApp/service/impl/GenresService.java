package com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Genre;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.EntityService;

import java.util.Arrays;
import java.util.List;

public class GenresService implements EntityService<Genre> {
    GenreDao dao;

    public GenresService(GenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List getAll() {
        return this.dao.findAll();
    }
}
