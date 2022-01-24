package com.ita.u1.skomorokhova.libraryApp.consts.jsp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class MainConsts {

    String APP_NAME = "Library";
    
    String BOOKS_BLOCK_TITLE = "Books";
    String ALL_BOOKS = "All books";
    String ALL_BOOKS_TABLE_VIEW = "Table view";
    String ALL_BOOKS_GALLERY_VIEW = "Gallery view";
    String ADD_BOOK = "Add book";

    String BOOKINGS_BLOCK_TITLE = "Bookings";
    String ALL_BOOKINGS = "All bookings";
    String ADD_BOOKING = "Add booking";

    String CLIENTS_BLOCK_TITLE = "Clients";
    String ALL_CLIENTS = "All clients";
    String ADD_CLIENT = "Add client";

    String AUTHORS_BLOCK_TITLE = "Authors";
    String ALL_AUTHORS = "All authors";
    String ADD_AUTHOR = "Add author";

    String VALID_FEEDBACK = "Looks good!";
    String VALID_FEEDBACK_CLASS = "valid-feedback";
    String INVALID_FEEDBACK_CLASS = "invalid-feedback";
    String BTN_SUBMIT = "Submit";

    String FOOTER_QUOTE = "A reader lives a thousand lives before he dies... The man who never reads lives only one.";
    String FOOTER_QUOTE_AUTHOR = "George R.R. Martin";
}
