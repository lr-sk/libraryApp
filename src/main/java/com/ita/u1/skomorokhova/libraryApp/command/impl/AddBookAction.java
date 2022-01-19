package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.JspPagesNames;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.impl.BookBuilder;
import lombok.extern.log4j.Log4j2;
import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Log4j2
public class AddBookAction implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        var bookBuilder = new BookBuilder();
//        bookBuilder.buildEntity(request);
//
//        response.sendRedirect("all-books");
        log.error("ProcessAddBook");
    }

}
