package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookConsts;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AuthorDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.EntityService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.AuthorService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.GenreService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.ImageService;
import com.ita.u1.skomorokhova.libraryApp.utils.RequestUtils;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookBuilder implements EntityBuilder<Book> {
    AddBookConsts consts = new AddBookConsts();

    @Override
    public Book buildEntity(ResultSet resultSet) throws SQLException {
        return Book.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .originalName(resultSet.getString("original_name"))
                .cost(resultSet.getBigDecimal("cost"))
                .costPerDay(resultSet.getBigDecimal("cost_per_day"))
                .yearOfPublishing(resultSet.getInt("year_of_publishing"))
                .numberOfPages(resultSet.getInt("number_of_pages"))
                .numberOfCopies(resultSet.getInt("number_of_copies"))
                .registrationDate(resultSet.getDate("registration_date").toLocalDate())
                .build();
    }

    public Book buildEntity(HttpServletRequest request) throws IOException, ServletException{
        val requestService = new RequestUtils();
        val imageService = new ImageService();
        val genreService = new GenreService(new GenreDaoImpl());
        val authorService = new AuthorService(new AuthorDaoImpl());

        val bookName = request.getParameter(consts.BOOK_NAME_ID);
        val imagesPart = requestService.getFileParts(request, consts.BOOK_IMAGE_ID);

        return Book.builder()
                .name(bookName)
                .originalName(request.getParameter(consts.ORIGINAL_BOOK_NAME_ID))
                .genres(getEntitiesListByIdList(request.getParameterMap().get(consts.GENRES_ID), genreService))
                .authors(getEntitiesListByIdList(request.getParameterMap().get(consts.AUTHORS_ID), authorService))
                .cost(new BigDecimal(request.getParameter(consts.BOOK_COST_ID)))
                .costPerDay(new BigDecimal(request.getParameter(consts.BOOK_COST_PER_DAY_ID)))
                .yearOfPublishing(Integer.parseInt(request.getParameter(consts.BOOK_YEAR_OF_PUBLISHING_ID)))
                .numberOfPages(Integer.parseInt(request.getParameter(consts.BOOK_NUMBER_OF_PAGES_ID)))
                .numberOfCopies(Integer.parseInt(request.getParameter(consts.BOOK_NUMBER_OF_COPIES_ID)))
                .registrationDate(LocalDate.parse(request.getParameter(consts.BOOK_DATE_OF_REGISTRATION_ID)))
                .images(imageService.setImagesList(imagesPart))
                .build();
    }

    private <T extends Entity> List<T> getEntitiesListByIdList(String[] idList, EntityService<T> entityService) {
        val values = new ArrayList<T>();

        for (String value: idList) {
            values.add(entityService.getById(Long.parseLong(value)));
        }

        return values;
    }
}
