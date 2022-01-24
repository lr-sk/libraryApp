package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.GenreSql.*;

public class GenreBuilder implements EntityBuilder<Genre> {

    @Override
    public Genre buildEntity(ResultSet resultSet) throws SQLException {
        return Genre.builder()
                .id(resultSet.getLong(GENRE_ID_COLUMN))
                .name(resultSet.getString(GENRE_NAME_COLUMN))
                .build();
    }
}
