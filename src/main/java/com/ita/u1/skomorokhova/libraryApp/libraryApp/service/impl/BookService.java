package com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.EntityService;

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
