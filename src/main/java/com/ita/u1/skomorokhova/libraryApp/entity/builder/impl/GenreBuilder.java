package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreBuilder implements EntityBuilder<Genre> {
    @Override
    public Genre buildEntity(ResultSet resultSet) throws SQLException {
        return Genre.builder()
                .id(Long.parseLong(resultSet.getString("id")))
                .name(resultSet.getString("name"))
                .build();
    }
}
