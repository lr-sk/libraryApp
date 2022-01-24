package com.ita.u1.skomorokhova.libraryApp.web.filters;

import com.ita.u1.skomorokhova.libraryApp.command.CommandType;
import com.ita.u1.skomorokhova.libraryApp.consts.Errors;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import lombok.extern.log4j.Log4j2;
import lombok.var;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.ita.u1.skomorokhova.libraryApp.command.CommandType.*;

@Log4j2
@WebFilter(urlPatterns = {"/*"})
public class CommandFilter implements Filter {
    private static Map<String, CommandType> commands = new HashMap<>();

    static {
        commands.put("/", MAIN_PAGE);
        commands.put("/main", MAIN_PAGE);
        commands.put("/all-books-table", ALL_BOOKS_TABLE);
        commands.put("/all-books-gallery", ALL_BOOKS_GALLERY);
        commands.put("/add-book", ADD_BOOK_PAGE);
        commands.put("/edit-book", EDIT_BOOK_PAGE);
        commands.put("/all-clients", ALL_CLIENTS_PAGE);
        commands.put("/add-client", ADD_CLIENT_PAGE);
        commands.put("/edit-client", EDIT_CLIENT_PAGE);
        commands.put("/all-bookings", ALL_BOOKINGS_PAGE);
        commands.put("/add-booking", ADD_BOOKING_PAGE);
        commands.put("/edit-booking", EDIT_BOOKING_PAGE);
        commands.put("/close-booking", CLOSE_BOOKING_PAGE);
        commands.put("/writing-off-books", WRITING_OFF_BOOKS_PAGE);
        commands.put("/library-yield", LIBRARY_YIELD_PAGE);
        commands.put("/search", SEARCH);
        commands.put("/add-book-processing", ADD_BOOK_ACTION);
        commands.put("/add-author-processing", ADD_AUTHOR_ACTION);
        commands.put("/add-client-processing", ADD_CLIENT_ACTION);
        commands.put("/add-booking-processing", ADD_BOOKING_ACTION);
        commands.put("/add-author", ADD_AUTHOR_PAGE);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            var httpServletRequest = (HttpServletRequest) servletRequest;
            var uri = httpServletRequest.getRequestURI();
            var commandType = commands.get(uri);
            httpServletRequest.setAttribute(GeneralConsts.COMMAND, commandType);
        } else {
            log.error(Errors.CANNOT_USE_COMMAND_FILTER);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }




    @Override
    public void destroy() {

    }
}
