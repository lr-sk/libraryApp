package com.ita.u1.skomorokhova.libraryApp.consts.db;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.SqlConstsService.selectAllIsNotDeletedFromTable;

public class AuthorSql {

    public static final String AUTHORS_TABLE = "authors";
    public static final String AUTHOR_ID_COLUMN = "author_id";
    public static final String AUTHOR_NAME_COLUMN = "author_name";
    public static final String AUTHOR_SURNAME_COLUMN = "author_surname";
    public static final String AUTHOR_PATRONYMIC_COLUMN = "author_patronymic";
    public static final String AUTHOR_IMAGE_COLUMN = "author_image";

    public static final String SELECT_ALL_AUTHORS = selectAllIsNotDeletedFromTable(AUTHORS_TABLE);
}
