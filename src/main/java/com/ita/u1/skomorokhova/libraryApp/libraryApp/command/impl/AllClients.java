package com.ita.u1.skomorokhova.libraryApp.libraryApp.command.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.command.Command;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.JspPagesNames;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.impl.ClientDaoImpl;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl.ClientService;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllClients implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val clientService = new ClientService(new ClientDaoImpl());
        request.setAttribute(GeneralConsts.BOOKS, clientService.getAll());
        request.getRequestDispatcher(JspPagesNames.ALL_CLIENTS_JSP).forward(request, response);
    }
}
