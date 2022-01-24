package com.ita.u1.skomorokhova.libraryApp.consts.db;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.GeneralSql.SELECT_ALL;

public class GenreSql {

    public static final String GENRES_TABLE = "genres";
    public static final String GENRE_ID_COLUMN = "genre_id";
    public static final String GENRE_NAME_COLUMN = "genre_name";

    public static final String SELECT_ALL_GENRES = SELECT_ALL + " genres";
    public static final String SELECT_GENRE_BY_ID = SELECT_ALL_GENRES + " WHERE " + GENRE_ID_COLUMN + " = ?";
}
