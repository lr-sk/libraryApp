package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.impl.ImageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookBuilder implements EntityBuilder<Book> {

    @Override
    public Book buildEntity(ResultSet resultSet) throws SQLException {
        return Book.builder()
                .id(Long.parseLong(resultSet.getString("id")))
                .name(resultSet.getString("name"))
                .originalName(resultSet.getString("original_name"))
                //genre
                //author
                .cost(resultSet.getBigDecimal("cost"))
                .costPerDay(resultSet.getBigDecimal("cost_per_day"))
                .yearOfPublishing(resultSet.getInt("year_of_publishing"))
                .numberOfPages(resultSet.getInt("number_of_pages"))
                .numberOfCopies(resultSet.getInt("number_of_copies"))
                .registrationDate(resultSet.getDate("registration_date").toLocalDate())
                //image
                .build();
    }

    public Book buildEntity(HttpServletRequest request) throws IOException, ServletException{
        return Book.builder()
                .name(request.getParameter("bookName"))
                .originalName(request.getParameter("originalBookName"))
                //genre
                //author
                .cost(new BigDecimal(request.getParameter("bookCost")))
                .costPerDay(new BigDecimal(request.getParameter("bookCostPerDay")))
                .yearOfPublishing(Integer.parseInt(request.getParameter("bookYearOfPublishing")))
                .numberOfPages(Integer.parseInt(request.getParameter("bookNumberOfPages")))
                .numberOfCopies(Integer.parseInt(request.getParameter("bookNumberOfCopies")))
                .registrationDate(LocalDate.parse(request.getParameter("bookRegistrationDate")))
                .images(new ImageService().setImagesList(request, "bookImages"))
                .build();
    }






}
