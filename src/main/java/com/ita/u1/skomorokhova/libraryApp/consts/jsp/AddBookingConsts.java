package com.ita.u1.skomorokhova.libraryApp.consts.jsp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class AddBookingConsts {

    String TITLE = "New booking";
    String MAIN_HEADER = "Add new booking";

    String CLIENT_ID = "bookingClientSelect";
    String CLIENT_LABEL = "Choose the client";
    String CLIENT_INVALID_FEEDBACK = "You have to select client";
    String CLIENT_ADD_NEW_OPTION = "Add new client";

    String BOOK_ID = "bookingBookSelect";
    String BOOK_LABEL = "Choose the book";
    String BOOK_INVALID_FEEDBACK = "You have to select al least one book";
    String BOOK_ADD_NEW_OPTION = "Add new book";

    String START_DATE_ID = "bookingStartDate";
    String START_DATE_LABEL = "Choose the start date";
    String START_DATE_INVALID_FEEDBACK = "Please provide a valid date";

    String END_DATE_ID = "bookingEndDate";
    String END_DATE_LABEL = "Choose the end date";
    String END_DATE_INVALID_FEEDBACK = "Please provide a valid date";

    String BOOKING_DETAILS = "Booking details";
}
