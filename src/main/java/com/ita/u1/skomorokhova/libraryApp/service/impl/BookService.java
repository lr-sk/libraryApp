package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import lombok.var;

import java.util.List;

public class BookService implements EntityService<Book> {
    BookDao dao;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Book> getAll() {
        return this.dao.findAll();
    }

    public boolean create(Book book) {
        return this.dao.create(book);
    }

    public boolean isEntityNameExist(List<Book> books, Book newBook) {
        var newBookName = newBook.getName();
        var newBookOriginalName = newBook.getOriginalName();
        for (Book book : books) {
            if (book.getName().equals(newBookName) || book.getOriginalName().equals(newBookOriginalName)) {
                return true;
            }
        }
        return false;
    }
}
