package com.ita.u1.skomorokhova.libraryApp.consts.jsp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class AddBookConsts {

   String TITLE = "New book";
   String MAIN_HEADER = "Add new book";
   String COST_PATTERN = "^\\d+[.,]?\\d*$";

   String BOOK_NAME_LABEL = "Book name";
   String BOOK_NAME_ID = "bookName";
   String BOOK_NAME_PLACEHOLDER = "Enter book name";
   String BOOK_NAME_INVALID_FEEDBACK = "Please provide a unique book name";

   String ORIGINAL_BOOK_NAME_LABEL = "Original name";
   String ORIGINAL_BOOK_NAME_ID = "originalBookName";
   String ORIGINAL_BOOK_NAME_PLACEHOLDER = "Enter original book name";
   String ORIGINAL_BOOK_NAME_INVALID_FEEDBACK = "Please provide a unique original book name";

   String GENRES_LABEL = "Choose genres";
   String GENRES_ID = "bookGenres";
   String GENRES_INVALID_FEEDBACK = "You have to select al least one genre";

   String AUTHORS_LABEL = "Choose authors";
   String AUTHORS_ID = "bookAuthors";
   String SELECTED_AUTHORS_BLOCK = "selectedAuthors";
   String AUTHORS_ADD_NEW_OPTION = "Add new author";
   String AUTHORS_INVALID_FEEDBACK = "You have to select al least one author or add new one";

   String BOOK_COST_LABEL = "Cost";
   String BOOK_COST_ID = "bookCost";
   String BOOK_COST_PLACEHOLDER = "Enter the cost";

   String BOOK_COST_HELP_BLOCK = "Cost must contain integer or float number separated by point or comma";
   String BOOK_COST_INVALID_FEEDBACK = "Please provide a valid cost";

   String BOOK_COST_PER_DAY_LABEL = "Cost per day";
   String BOOK_COST_PER_DAY_ID = "bookCostPerDay";
   String BOOK_COST_PER_DAY_PLACEHOLDER = "Enter the cost per day";

   String BOOK_YEAR_OF_PUBLISHING_LABEL = "Year of publishing";
   String BOOK_YEAR_OF_PUBLISHING_ID = "bookYearOfPublishing";
   String BOOK_YEAR_OF_PUBLISHING_PLACEHOLDER = "Enter the year of publishing";
   String BOOK_YEAR_OF_PUBLISHING_INVALID_FEEDBACK = "Please provide a valid year";

   String BOOK_NUMBER_OF_PAGES_LABEL = "Number of pages";
   String BOOK_NUMBER_OF_PAGES_ID = "bookNumberOfPages";
   String BOOK_NUMBER_OF_PAGES_PLACEHOLDER = "Enter the number of pages";

   String BOOK_NUMBER_INVALID_FEEDBACK = "Please provide an integer number";

   String BOOK_NUMBER_OF_COPIES_LABEL = "Number of copies";
   String BOOK_NUMBER_OF_COPIES_ID = "bookNumberOfCopies";
   String BOOK_NUMBER_OF_COPIES_PLACEHOLDER = "Enter the number of copies";

   String BOOK_DATE_OF_REGISTRATION_LABEL = "Registration date";
   String BOOK_DATE_OF_REGISTRATION_ID = "bookRegistrationDate";

   String BOOK_IMAGE_LABEL = "Image";
   String BOOK_IMAGE_ID = "bookImages";
   String BOOK_IMAGE_HELP_BLOCK = "Choose images to upload (PNG, JPG), maximum size of the file is 2Mb";
   String BOOK_IMAGE_INVALID_FEEDBACK = "Please provide a valid image file";
}
