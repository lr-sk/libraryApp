package com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.jsp;

import lombok.Value;

@Value
    class AddBookJspConsts {
        String TITLE = "New book";
        String MAIN_HEADER = "Add new book";

        String BOOK_NAME_LABEL = "Book name";
        String BOOK_NAME_PLACEHOLDER = "Enter book name";
        String BOOK_NAME_INVALID_FEEDBACK = "Please provide a book name";

        String ORIGINAL_BOOK_NAME_LABEL = "Book name";
        String ORIGINAL_BOOK_NAME_PLACEHOLDER = "Enter original book name";
        String ORIGINAL_BOOK_NAME_INVALID_FEEDBACK = "Please provide a original book name";

        String GENRES_LABEL = "Select genres";
        String GENRES_ADD_NEW_OPTION = "Select genres";
        String GENRES_INVALID_FEEDBACK = "You have to select al least one genre or add new one";

        String AUTHORS_LABEL = "Select authors";
        String AUTHORS_ADD_NEW_OPTION = "Add new author";
        String AUTHORS_INVALID_FEEDBACK = "You have to select al least one author or add new one";

        String BOOK_COST_LABEL = "Book cost";
        String BOOK_COST_PLACEHOLDER = "Enter the cost";
        String BOOK_COST_HELP_BLOCK = "Cost must contain integer or float number separated by a point";
        String BOOK_COST_INVALID_FEEDBACK = "Please provide a valid cost";

        String BOOK_COST_PER_DAY_LABEL = "Book name";
        String BOOK_COST_PER_DAY_PLACEHOLDER = "Enter the cost per day";
        String BOOK_COST_PER_DAY_INVALID_FEEDBACK = "Please provide a book name";

        String BOOK_YEAR_OF_PUBLISHING_LABEL = "Book name";
        String BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER = "Enter the year of publishing";
        String BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK = "Please provide a book name";

        String BOOK_NUMBER_OF_PAGES_LABEL = "Book name";
        String BOOK_NUMBER_OF_PAGES_PLACEHOLDER = "Enter the number of pages";
        String BOOK_NUMBER_OF_PAGES_INVALID_FEEDBACK = "Please provide a book name";

        String BOOK_NUMBER_OF_COPIES_LABEL = "Book name";
        String BOOK_NUMBER_OF_COPIES_PLACEHOLDER = "Enter the number of copies";
        String BOOK_NUMBER_OF_COPIES_INVALID_FEEDBACK = "Please provide a book name";

        String BOOK_DATE_OF_REGISTRATION_LABEL = "Book name";
        String BOOK_DATE_OF_REGISTRATION_PLACEHOLDER = "Choose the registration date";
        String BOOK_DATE_OF_REGISTRATION_INVALID_FEEDBACK = "Please provide a book name";
}
