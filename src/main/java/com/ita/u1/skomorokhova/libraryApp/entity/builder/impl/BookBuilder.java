package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookBuilder implements EntityBuilder<Book> {

    @Override
    public Book buildEntity(ResultSet resultSet) throws SQLException {
        return Book.builder()
                .name(resultSet.getString("name"))
                .originalName(resultSet.getString("original_name"))
                .cost(resultSet.getBigDecimal("cost"))
                .costPerDay(resultSet.getBigDecimal("cost_per_day"))
                .yearOfPublishing(resultSet.getInt("year_of_publishing"))
                .numberOfPages(resultSet.getInt("number_of_pages"))
                .numberOfCopies(resultSet.getInt("number_of_copies"))
                .registrationDate(resultSet.getTimestamp("registration_date").toLocalDateTime().toLocalDate())
                .build();
    }
}
