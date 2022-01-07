package com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.connectionPool.DBCPDataSource;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.Errors;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.SqlConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.builder.impl.BookBuilder;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Genre;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class BookDaoImpl implements BookDao {

    @Override
    public Book findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Book book) {
        return false;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {

        val books = new ArrayList<Book>();
        val bookBuilder = new BookBuilder();
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBCPDataSource.getConnection();
            preparedStatement = connection.prepareStatement(SqlConsts.SELECT_ALL_BOOKS);
            val resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                books.add(bookBuilder.buildEntity(resultSet));
            }

        } catch (SQLException e) {
            log.error(Errors.DATABASE_ACCESS_ERROR);
        }

        return books;
    }

    @Override
    public List<Book> findBookByName(String name) {
        return null;
    }

    @Override
    public List<Book> findBookByOriginalName(String originalName) {
        return null;
    }

    @Override
    public List<Book> findBookByYearOfPublishing(int year) {
        return null;
    }

    @Override
    public List<Book> findBookByGenre(Genre genre) {
        return null;
    }

    @Override
    public List<Book> findBookByAuthor(Author author) {
        return null;
    }
}
