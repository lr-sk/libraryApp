package com.ita.u1.skomorokhova.libraryApp.dao.impl;


import com.ita.u1.skomorokhova.libraryApp.connectionPool.PooledDataSource;
import com.ita.u1.skomorokhova.libraryApp.dao.BaseDao;
import com.ita.u1.skomorokhova.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.BookCopy;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Image;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.BookSql.*;

@Log4j2
public class AddBookDao implements BaseDao<Long, Book> {

    private final BookDao bookDao;


    public AddBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

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

        try (val connection = getConnection()) {
            connection.setAutoCommit(false);
            val savepoint =  connection.setSavepoint();
            val bookId = bookDao.create(book, connection);
            val isBookInserted = bookId > 0;
            val isBookGenresInserted = insertValuesList(book, INSERT_BOOK_GENRES, book.getGenres(), connection);
            val isBookAuthorsInserted = insertValuesList(book, INSERT_BOOK_AUTHORS, book.getAuthors(), connection);
            val isBookImagesInserted = insertImagesList(book, INSERT_BOOK_DESCRIPTIONS_IMAGES, book.getImages(), connection);
            val isBookCopiesInserted = insertBookCopies(book, INSERT_BOOK_COPIES, connection);

            if (isBookInserted && isBookGenresInserted && isBookAuthorsInserted
                    && isBookImagesInserted && isBookCopiesInserted) {
                connection.commit();
                connection.setAutoCommit(true);
                return true;
            } else {
                connection.rollback(savepoint);
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return false;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    private Connection getConnection() throws SQLException {
        return PooledDataSource.getConnection();
    }

    private boolean createBook(Book book) {
        return bookDao.create(book);
    }

    private <T extends Entity> boolean insertValuesList(Book book, String query, List<T> values, Connection connection) {
        val newItems = new ArrayList<Integer>();

        try {
            connection.setAutoCommit(false);
            try (val preparedStatement = connection.prepareStatement(query)) {
                for (T value : values) {
                    preparedStatement.setLong(1, book.getId());
                    preparedStatement.setLong(2, value.getId());

                    val resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        newItems.add(resultSet.getInt("id"));
                    }
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return values.size() == newItems.size();
    }


    private boolean insertImagesList(Book book, String query, List<Image> values, Connection connection) {
        val newItems = new ArrayList<Integer>();

        try {
            connection.setAutoCommit(false);
            try (val preparedStatement = connection.prepareStatement(query)) {
                for (Image value : values) {
                    preparedStatement.setLong(1, book.getId());
                    preparedStatement.setString(2, value.getImageString());

                    val resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        newItems.add(resultSet.getInt("id"));
                    }
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return values.size() == newItems.size();
    }

    private boolean insertBookCopies(Book book, String query, Connection connection) {
        val newItems = new ArrayList<Integer>();
        val numberOfCopies = book.getNumberOfCopies();
        val bookCopy = BookCopy.builder().build();
        try {
            connection.setAutoCommit(false);
            try (val preparedStatement = connection.prepareStatement(query)) {
                for (int i = 1; i < numberOfCopies; i++) {

                    preparedStatement.setLong(1, book.getId());
                    preparedStatement.setLong(2, bookCopy.getStateId());
                    preparedStatement.setBoolean(3, bookCopy.isAvailable());
                    preparedStatement.setBoolean(4, bookCopy.isDeleted());

                    val resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        newItems.add(resultSet.getInt("id"));
                    }
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return numberOfCopies == newItems.size();
    }
}
