package com.ita.u1.skomorokhova.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AddBookDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import lombok.val;
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

    @Override
    public Book getById(long parseLong) {
        return null;
    }

    public boolean create(Book book) {
        val addBookTransaction = new AddBookDao(dao);
        return addBookTransaction.create(book);
    }

    public boolean isBookNameExist(Book newBook) {
        val newBookName = newBook.getName();
        val allBooks =  getAll();
        for (Book book : allBooks) {
            if (book.getName().equals(newBookName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isOriginalBookNameExist(Book newBook) {
        var newBookOriginalName = newBook.getOriginalName();
        for (Book book : getAll()) {
            if (book.getOriginalName().equals(newBookOriginalName)) {
                return true;
            }
        }
        return false;
    }
}
