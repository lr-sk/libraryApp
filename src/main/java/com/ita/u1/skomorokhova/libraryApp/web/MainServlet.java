package com.ita.u1.skomorokhova.libraryApp.web;

import com.ita.u1.skomorokhova.libraryApp.command.CommandFactory;
import com.ita.u1.skomorokhova.libraryApp.command.CommandType;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import com.ita.u1.skomorokhova.libraryApp.exceptions.UnknownCommandException;
import lombok.extern.log4j.Log4j2;
import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "main", value = "/")
@MultipartConfig
public class MainServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }


    public void destroy() {

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var commandFactory = new CommandFactory();
        var attributeCommand = request.getAttribute(GeneralConsts.COMMAND);

        if (attributeCommand != null) {
            log.info(GeneralConsts.ATTRIBUTE + " " + attributeCommand);
            try {
                var command = commandFactory.createCommand((CommandType) attributeCommand);
                command.execute(request, response);
            } catch (UnknownCommandException e) {
                log.error(GeneralConsts.UNKNOWN_COMMAND);
            }
        }
    }


}
