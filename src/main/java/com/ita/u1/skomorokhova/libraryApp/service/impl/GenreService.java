package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;

import java.util.ArrayList;
import java.util.List;

public class GenreService implements EntityService<Genre> {
    GenreDao dao;

    public GenreService(GenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Genre> getAll() {
        return this.dao.findAll();
    }

    public List<String> getAllNames() {
        List<String> names = new ArrayList<>();

        for (Genre genre : getAll()) {
            names.add(genre.getName());
        }

        return names;
    }
}
