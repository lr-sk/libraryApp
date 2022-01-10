package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;

import java.util.List;

public class BookService implements EntityService<Book> {
    BookDao dao;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List getAll() {
        return this.dao.findAll();
    }
}
