package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.AuthorDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import java.util.List;

public class AuthorService implements EntityService<Author> {
    AuthorDao dao;

    public AuthorService(AuthorDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Author> getAll() {
        return this.dao.findAll();
    }

    @Override
    public Author getById(long parseLong) {
        return null;
    }

}
