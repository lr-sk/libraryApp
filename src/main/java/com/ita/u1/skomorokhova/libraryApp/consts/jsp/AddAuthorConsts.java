package com.ita.u1.skomorokhova.libraryApp.consts.jsp;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Getter
@Accessors(fluent = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class AddAuthorConsts {

    String TITLE = "New author";
    String MAIN_HEADER = "Add new author";

    String AUTHOR_NAME_ID = "authorName";
    String AUTHOR_NAME_LABEL = "Name";
    String AUTHOR_NAME_PLACEHOLDER = "Enter name";
    String AUTHOR_NAME_INVALID_FEEDBACK = "Please provide an author name";

    String AUTHOR_SURNAME_ID = "authorSurname";
    String AUTHOR_SURNAME_LABEL = "Surname";
    String AUTHOR_SURNAME_PLACEHOLDER = "Enter surname";
    String AUTHOR_SURNAME_INVALID_FEEDBACK = "Please provide an author surname";

    String AUTHOR_PATRONYMIC_ID = "authorPatronymic";
    String AUTHOR_PATRONYMIC_SWITCH_LABEL = "Provide patronymic";
    String AUTHOR_PATRONYMIC_PLACEHOLDER = "Enter patronymic";
    String AUTHOR_PATRONYMIC_INVALID_FEEDBACK = "Please provide an author patronymic";

    String AUTHOR_IMAGE_ID = "authorImage";
    String AUTHOR_IMAGE_LABEL = "";
    String AUTHOR_IMAGE_HELP_BLOCK = "Choose images to upload (PNG, JPG), maximum size of the file is 2Mb";
    String AUTHOR_IMAGE_INVALID_FEEDBACK = "";
}
