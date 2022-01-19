package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.consts.JspPagesNames;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AuthorDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.service.impl.AuthorService;
import com.ita.u1.skomorokhova.libraryApp.service.impl.GenreService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val genresService = new GenreService(new GenreDaoImpl());
        val authorService = new AuthorService(new AuthorDaoImpl());
        request.setAttribute(GeneralConsts.GENRES, genresService.getAllNames());
        request.setAttribute(GeneralConsts.AUTHORS, authorService.getAll());
        request.getRequestDispatcher(JspPagesNames.ADD_BOOK_JSP).forward(request, response);
    }
}
