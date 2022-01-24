package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.jsp.AddBookConsts;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AuthorDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.BookDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.ImageDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.impl.BookBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.service.impl.AuthorService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.BookService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.GenreService;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts.AUTHORS;
import static com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts.GENRES;
import static com.ita.u1.skomorokhova.libraryApp.consts.PathConsts.ADD_BOOK_PATH;


@Log4j2
public class AddBookAction implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val bookBuilder = new BookBuilder();
        val authorDao = new AuthorDaoImpl();
        val genreDao = new GenreDaoImpl();
        val imageDao = new ImageDaoImpl();
        val bookService = new BookService(new BookDaoImpl(authorDao, genreDao, imageDao));
        val genreService = new GenreService(genreDao);
        val authorService = new AuthorService(authorDao);

        val book = bookBuilder.buildEntity(request);

        val isCreatedMsg = "isCreated";
        val failedMsg = "failed";

        if (isBookExist(bookService, book, request)) {
            request.setAttribute(failedMsg, true);
            returnUserInput(request, book);
            request.setAttribute(GENRES, genreService.getAll());
            request.setAttribute(AUTHORS, authorService.getAll());

        } else {
            request.setAttribute(isCreatedMsg, bookService.create(book));
        }

        request.getRequestDispatcher(ADD_BOOK_PATH).forward(request, response);
    }

    private void returnUserInput(HttpServletRequest request, Book book) {
        AddBookConsts consts = new AddBookConsts();
        request.setAttribute("name",  book.getName());
        request.setAttribute("originalName",  book.getOriginalName());
        request.setAttribute("selectedGenres",  book.getGenres());
        request.setAttribute("selectedAuthors",  book.getAuthors());
        request.setAttribute("cost",  book.getCost());
        request.setAttribute("costPerDay",  book.getCostPerDay());
        request.setAttribute("year",  book.getYearOfPublishing());
        request.setAttribute("pages",  book.getNumberOfPages());
        request.setAttribute("copies",  book.getNumberOfCopies());
    }

    private boolean isBookExist(BookService bookService, Book book, HttpServletRequest request) {
        boolean isNameExist = bookService.isBookNameExist(book);
        boolean isOriginalNameExist = bookService.isOriginalBookNameExist(book);

        request.setAttribute("existingBookName", isNameExist);
        request.setAttribute("existingOriginalBookName", isOriginalNameExist);

        return  isNameExist || isOriginalNameExist;
    }

}
