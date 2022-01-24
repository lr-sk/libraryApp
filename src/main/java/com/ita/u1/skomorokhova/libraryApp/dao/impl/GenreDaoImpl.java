package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.connectionPool.PooledDataSource;
import com.ita.u1.skomorokhova.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.impl.GenreBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.GenreSql.*;

public class GenreDaoImpl implements GenreDao {

    public EntityBuilder<Genre> getEntityBuilder() {
        return new GenreBuilder();
    }

    @Override
    public List<Genre> findAll() {
        val genres = new ArrayList<Genre>();
        val genreBuilder = getEntityBuilder();

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(SELECT_ALL_GENRES);
             val resultSet = preparedStatement.executeQuery();) {

            while(resultSet.next()){
                genres.add(genreBuilder.buildEntity(resultSet));
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return genres;
    }

    @Override
    public Genre findEntityById(Long id) {
        val genreBuilder = getEntityBuilder();
        Genre genre = Genre.builder().build();

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(SELECT_GENRE_BY_ID)) {

            preparedStatement.setLong(1, id);

            try (val resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()){
                    return genreBuilder.buildEntity(resultSet);
                }
            }

        } catch (SQLException e) {
            log.error(e.getMessage());
        }

        return genre;
    }

    @Override
    public boolean delete(Genre genre) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Genre genre) {
        return false;
    }

    @Override
    public Genre update(Genre genre) {
        return null;
    }

    public List<Genre> findAllByBookId(Long bookId, String query) {
        val valuesList = new ArrayList<Genre>();

        try {
            val connection = getConnection();
            val preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, bookId);
            val resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                val id = resultSet.getLong(GENRE_ID_COLUMN);
                val name = resultSet.getString(GENRE_NAME_COLUMN);

                val genre = Genre.builder()
                        .id(id)
                        .name(name)
                        .build();

                valuesList.add(genre);
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
