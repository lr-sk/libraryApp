package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.connectionPool.PooledDataSource;
import com.ita.u1.skomorokhova.libraryApp.dao.AuthorDao;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.impl.AuthorBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.AuthorSql.SELECT_ALL_AUTHORS;

public class AuthorDaoImpl implements AuthorDao {

    public EntityBuilder<Author> getEntityBuilder() {
        return new AuthorBuilder();
    }

    @Override
    public List<Author> findAll() {
        val authors = new ArrayList<Author>();
        val authorBuilder = getEntityBuilder();

        try (val connection = getConnection();
            val preparedStatement = connection.prepareStatement(SELECT_ALL_AUTHORS);
            val resultSet = preparedStatement.executeQuery()) {

            while(resultSet.next()){
                authors.add(authorBuilder.buildEntity(resultSet));
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return authors;
    }

    @Override
    public Author findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Author author) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Author author) {
        return false;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public List<Author> findAllByBookId(Long bookId, String query) {
        val valuesList = new ArrayList<Author>();
        val authorBuilder = getEntityBuilder();

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(query);){

            preparedStatement.setLong(1, bookId);

            try (val resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    valuesList.add(authorBuilder.buildEntity(resultSet));
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return valuesList;
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
