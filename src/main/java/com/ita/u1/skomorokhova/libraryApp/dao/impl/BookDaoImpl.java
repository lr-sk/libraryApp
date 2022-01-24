package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.connectionPool.PooledDataSource;
import com.ita.u1.skomorokhova.libraryApp.dao.AuthorDao;
import com.ita.u1.skomorokhova.libraryApp.dao.BookDao;
import com.ita.u1.skomorokhova.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.dao.ImageDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.BookSql.*;

@Log4j2
public class BookDaoImpl implements BookDao {

    AuthorDao authorDao;
    GenreDao genreDao;
    ImageDao imageDao;

    public BookDaoImpl(AuthorDao authorDao, GenreDao genreDao, ImageDao imageDao) {
        this.authorDao = authorDao;
        this.genreDao = genreDao;
        this.imageDao = imageDao;
    }

    @Override
    public List<Book> findAll() {
        val books = new ArrayList<Book>();

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);
             val resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()){
                val bookId = resultSet.getLong(BOOK_ID_COLUMN);
                val book = findEntityById(bookId);
                books.add(book);
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return books;
    }

    @Override
    public Book findEntityById(Long id) {

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)) {

            preparedStatement.setLong(1, id);
            try(val resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    val name = resultSet.getString(BOOK_NAME_COLUMN);
                    val originalName = resultSet.getString(BOOK_ORIGINAL_NAME_COLUMN);
                    val cost = resultSet.getBigDecimal(BOOK_COST_COLUMN);
                    val costPerDay = resultSet.getBigDecimal(BOOK_COST_PER_DAY_COLUMN);
                    val yearOfPublishing = resultSet.getInt(BOOK_YEAR_COLUMN);
                    val numberOfPages = resultSet.getInt(BOOK_PAGES_COLUMN);
                    val numberOfCopies = resultSet.getInt(BOOK_COPIES_NUMBER_COLUMN);
                    val registrationDate = resultSet.getDate(BOOK_DATE_COLUMN).toLocalDate();

                    val authorsList = authorDao.findAllByBookId(id, SELECT_BOOK_AUTHORS);
                    val genresList = genreDao.findAllByBookId(id, SELECT_BOOK_GENRES);
                    val imagesList = imageDao.findAllByBookId(id, SELECT_BOOK_IMAGES);


                    return Book.builder()
                            .id(id)
                            .name(name)
                            .originalName(originalName)
                            .genres(genresList)
                            .authors(authorsList)
                            .cost(cost)
                            .costPerDay(costPerDay)
                            .yearOfPublishing(yearOfPublishing)
                            .numberOfPages(numberOfPages)
                            .numberOfCopies(numberOfCopies)
                            .registrationDate(registrationDate)
                            .images(imagesList)
                            .build();
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return Book.builder().build();
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
        return create(book, getConnection()) > 0;
    }

    public long create(Book book, Connection connection) {

        try {
            val preparedStatement = connection.prepareStatement(INSERT_BOOK);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getOriginalName());
            preparedStatement.setBigDecimal(3, book.getCost());
            preparedStatement.setBigDecimal(4, book.getCostPerDay());
            preparedStatement.setInt(5, book.getYearOfPublishing());
            preparedStatement.setInt(6, book.getNumberOfPages());
            preparedStatement.setInt(7, book.getNumberOfCopies());
            preparedStatement.setDate(8, Date.valueOf(book.getRegistrationDate()));
            preparedStatement.setBoolean(9, false);

            val resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt(BOOK_ID_COLUMN);
            }

        } catch (SQLException e) {
            log.error(e.getMessage() );
        }
        return -1;
    }


    @Override
    public Book update(Book book) {
        return null;
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

    private Connection getConnection() {
        try {
            return PooledDataSource.getConnection();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

}
