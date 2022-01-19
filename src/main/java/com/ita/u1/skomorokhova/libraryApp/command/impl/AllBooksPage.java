package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.consts.JspPagesNames;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.BookDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.service.impl.BookService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllBooksPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val bookService = new BookService(new BookDaoImpl());
        request.setAttribute(GeneralConsts.BOOKS, bookService.getAll());
        request.getRequestDispatcher(JspPagesNames.ALL_BOOKS_JSP).forward(request, response);
    }
}
