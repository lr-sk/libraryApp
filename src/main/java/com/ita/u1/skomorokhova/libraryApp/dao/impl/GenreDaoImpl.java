package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;

import java.util.List;

public class GenreDaoImpl implements GenreDao {
    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Genre findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Genre genre) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Genre genre) {
        return false;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }
}
