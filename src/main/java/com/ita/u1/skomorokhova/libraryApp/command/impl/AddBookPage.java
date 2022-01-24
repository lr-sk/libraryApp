package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AuthorDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.service.impl.AuthorService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.GenreService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts.*;
import static com.ita.u1.skomorokhova.libraryApp.consts.PathConsts.ADD_BOOK_PATH;

public class AddBookPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val genreService = new GenreService(new GenreDaoImpl());
        val authorService = new AuthorService(new AuthorDaoImpl());
        request.setAttribute(GENRES, genreService.getAll());
        request.setAttribute(AUTHORS, authorService.getAll());
        request.getRequestDispatcher(ADD_BOOK_PATH).forward(request, response);
    }
}
