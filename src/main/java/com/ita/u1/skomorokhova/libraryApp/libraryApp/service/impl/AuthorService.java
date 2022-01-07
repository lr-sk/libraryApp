package com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.AuthorDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.EntityService;

import java.util.List;

public class AuthorService implements EntityService<Author> {
    AuthorDao dao;

    public AuthorService(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public List getAll() {
        return this.dao.findAll();
    }
}
