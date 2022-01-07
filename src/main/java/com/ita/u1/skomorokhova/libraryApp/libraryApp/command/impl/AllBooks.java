package com.ita.u1.skomorokhova.libraryApp.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.JspConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.impl.BookDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl.BookService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllBooks implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val bookService = new BookService(new BookDaoImpl());
        request.setAttribute(GeneralConsts.BOOKS, bookService.getAll());
        request.getRequestDispatcher(JspConsts.ALL_BOOKS_JSP).forward(request, response);
    }
}
