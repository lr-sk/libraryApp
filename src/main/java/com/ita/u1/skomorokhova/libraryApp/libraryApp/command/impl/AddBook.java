package com.ita.u1.skomorokhova.libraryApp.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.JspConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl.GenresService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBook implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val genresService = new GenresService(new GenreDaoImpl());
        request.setAttribute(GeneralConsts.GENRES, genresService.getAll());
        request.getRequestDispatcher(JspConsts.ADD_BOOK_JSP).forward(request, response);
    }
}
