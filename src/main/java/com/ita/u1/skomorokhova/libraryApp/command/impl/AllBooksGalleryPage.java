package com.ita.u1.skomorokhova.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.consts.PathConsts;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.AuthorDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.BookDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.GenreDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.dao.impl.ImageDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.service.impl.BookService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllBooksGalleryPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val authorDao = new AuthorDaoImpl();
        val genreDao = new GenreDaoImpl();
        val imageDao = new ImageDaoImpl();
        val bookService = new BookService(new BookDaoImpl(authorDao, genreDao, imageDao));
        request.setAttribute(GeneralConsts.BOOKS, bookService.getAll());
        request.getRequestDispatcher(PathConsts.ALL_BOOKS_GALLERY_PATH).forward(request, response);
    }
}
