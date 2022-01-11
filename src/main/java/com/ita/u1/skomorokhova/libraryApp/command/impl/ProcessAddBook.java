package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.JspPagesNames;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ProcessAddBook implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameter("bookName");
        request.getParameter("originalBookName");
        request.getParameter("bookGenres");
        request.getParameter("bookAuthors");
        request.getParameter("bookCost");
        request.getParameter("bookCostPerDay");
        request.getParameter("bookYearOfPublishing");
        request.getParameter("bookNumberOfPages");
        request.getParameter("bookNumberOfCopies");
        request.getParameter("bookRegistrationDate");
        request.getParameter("bookImages");

        response.sendRedirect("all-books");
    }
}
