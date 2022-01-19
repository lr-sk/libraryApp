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

@Log4j2
@WebFilter(urlPatterns = {"/*"})
public class CommandFilter implements Filter {
    private static Map<String, CommandType> commands = new HashMap<>();

    static {
        commands.put("/", CommandType.MAIN_PAGE);
        commands.put("/main", CommandType.MAIN_PAGE);
        commands.put("/all-books", CommandType.ALL_BOOKS_PAGE);
        commands.put("/add-book", CommandType.ADD_BOOK_PAGE);
        commands.put("/edit-book", CommandType.EDIT_BOOK_PAGE);
        commands.put("/all-clients", CommandType.ALL_CLIENTS_PAGE);
        commands.put("/add-client", CommandType.ADD_CLIENT_PAGE);
        commands.put("/edit-client", CommandType.EDIT_CLIENT_PAGE);
        commands.put("/all-bookings", CommandType.ALL_BOOKINGS_PAGE);
        commands.put("/add-booking", CommandType.ADD_BOOKING_PAGE);
        commands.put("/edit-booking", CommandType.EDIT_BOOKING_PAGE);
        commands.put("/close-booking", CommandType.CLOSE_BOOKING_PAGE);
        commands.put("/writing-off-books", CommandType.WRITING_OFF_BOOKS_PAGE);
        commands.put("/library-yield", CommandType.LIBRARY_YIELD_PAGE);
        commands.put("/search", CommandType.SEARCH);
        commands.put("/process-add-book", CommandType.ADD_BOOK_ACTION);
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
