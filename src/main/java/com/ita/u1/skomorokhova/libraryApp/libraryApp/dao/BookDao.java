package com.ita.u1.skomorokhova.libraryApp.libraryApp.dao;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Genre;

import java.util.List;

public interface BookDao extends BaseDao<Long, Book>{
    List<Book> findAll();
    List<Book> findBookByName(String name);
    List<Book> findBookByOriginalName(String originalName);
    List<Book> findBookByYearOfPublishing(int year);
    List<Book> findBookByGenre(Genre genre);
    List<Book> findBookByAuthor(Author author);
}
