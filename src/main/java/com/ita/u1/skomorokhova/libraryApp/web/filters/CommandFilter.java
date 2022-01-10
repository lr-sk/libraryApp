package com.ita.u1.skomorokhova.libraryApp.web.filters;

import com.ita.u1.skomorokhova.libraryApp.command.impl.CommandType;
import com.ita.u1.skomorokhova.libraryApp.consts.Errors;
import com.ita.u1.skomorokhova.libraryApp.consts.GeneralConsts;
import lombok.extern.log4j.Log4j2;

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
        commands.put("/all-books", CommandType.ALL_BOOKS);
        commands.put("/add-book", CommandType.ADD_BOOK);
        commands.put("/edit-book", CommandType.EDIT_BOOK);
        commands.put("/all-clients", CommandType.ALL_CLIENTS);
        commands.put("/add-client", CommandType.ADD_CLIENT);
        commands.put("/edit-client", CommandType.EDIT_CLIENT);
        commands.put("/all-bookings", CommandType.ALL_BOOKINGS);
        commands.put("/add-booking", CommandType.ADD_BOOKING);
        commands.put("/edit-booking", CommandType.EDIT_BOOKING);
        commands.put("/close-booking", CommandType.CLOSE_BOOKING);
        commands.put("/writing-off-books", CommandType.WRITING_OFF_BOOKS);
        commands.put("/library-yield", CommandType.LIBRARY_YIELD);
        commands.put("/search", CommandType.SEARCH);
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            String uri = httpServletRequest.getRequestURI();
            CommandType commandType = commands.get(uri);
            httpServletRequest.setAttribute(GeneralConsts.COMMAND, commandType);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            log.error(Errors.CANNOT_USE_COMMAND_FILTER);
        }
    }

    @Override
    public void destroy() {

    }
}
