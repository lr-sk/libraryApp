package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.connectionPool.DBCPDataSource;
import com.ita.u1.skomorokhova.libraryApp.consts.Errors;
import com.ita.u1.skomorokhova.libraryApp.consts.SqlConsts;
import com.ita.u1.skomorokhova.libraryApp.dao.GenreDao;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.impl.GenreBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;
import lombok.val;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoImpl implements GenreDao {
    @Override
    public List<Genre> findAll() {
        val genres = new ArrayList<Genre>();
        val genreBuilder = new GenreBuilder();
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            connection = DBCPDataSource.getConnection();
            preparedStatement = connection.prepareStatement(SqlConsts.SELECT_ALL_GENRES);
            val resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                genres.add(genreBuilder.buildEntity(resultSet));
            }

        } catch (SQLException e) {
            log.error(Errors.DATABASE_ACCESS_ERROR);
        }

        return genres;
    }

    @Override
    public Genre findEntityById(Long id) {
        return null;
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

}
