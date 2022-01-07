package com.ita.u1.skomorokhova.libraryApp.libraryApp.command;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.command.impl.*;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.exceptions.UnknownCommandException;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommandFactory {
    public Command createCommand(CommandType commandType) throws UnknownCommandException {
        switch (commandType) {
            case MAIN_PAGE:
                return new MainPage();
            case ALL_BOOKS:
                return new AllBooks();
            case ADD_BOOK:
                return new AddBook();
            case EDIT_BOOK:
                return new EditBook();
            case ALL_CLIENTS:
                return new AllClients();
            case ADD_CLIENT:
                return new AddClient();
            case EDIT_CLIENT:
                return new EditClient();
            case ALL_BOOKINGS:
                return new AllBookings();
            case ADD_BOOKING:
                return new AddBooking();
            case EDIT_BOOKING:
                return new EditBooking();
            case CLOSE_BOOKING:
                return new CloseBooking();
            case WRITING_OFF_BOOKS:
                return new WritingOffBooks();
            case LIBRARY_YIELD:
                return new LibraryYield();
            case SEARCH:
                return new Search();
            default:
                throw new UnknownCommandException();
        }
    }
}
