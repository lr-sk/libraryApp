package com.ita.u1.skomorokhova.libraryApp.command;

import com.ita.u1.skomorokhova.libraryApp.command.impl.*;
import com.ita.u1.skomorokhova.libraryApp.exceptions.UnknownCommandException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommandFactory {
    public Command createCommand(CommandType commandType) throws UnknownCommandException {
        switch (commandType) {
            case MAIN_PAGE:
                return new MainPage();
            case ALL_BOOKS_PAGE:
                return new AllBooksPage();
            case ADD_BOOK_PAGE:
                return new AddBookPage();
            case EDIT_BOOK_PAGE:
                return new EditBookPage();
            case ALL_CLIENTS_PAGE:
                return new AllClientsPage();
            case ADD_CLIENT_PAGE:
                return new AddClientPage();
            case EDIT_CLIENT_PAGE:
                return new EditClientPage();
            case ALL_BOOKINGS_PAGE:
                return new AllBookingsPage();
            case ADD_BOOKING_PAGE:
                return new AddBookingPage();
            case EDIT_BOOKING_PAGE:
                return new EditBookingPage();
            case CLOSE_BOOKING_PAGE:
                return new CloseBookingPage();
            case WRITING_OFF_BOOKS_PAGE:
                return new WritingOffBooksPage();
            case LIBRARY_YIELD_PAGE:
                return new LibraryYieldPage();
            case SEARCH:
                return new Search();
            case ADD_BOOK_ACTION:
                return new AddBookAction();
            default:
                throw new UnknownCommandException();
        }
    }
}
