package com.ita.u1.skomorokhova.libraryApp.consts.db;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.AuthorSql.*;
import static com.ita.u1.skomorokhova.libraryApp.consts.db.GenreSql.*;
import static com.ita.u1.skomorokhova.libraryApp.consts.db.ImageSql.*;
import static com.ita.u1.skomorokhova.libraryApp.consts.db.SqlConstsService.*;

public class BookSql {

    public static final String BOOK_COPIES_TABLE = "book_copies";

    public static final String BOOK_DESCRIPTIONS_TABLE = "book_descriptions";
    public static final String BOOK_ID_COLUMN = "book_id";
    public static final String BOOK_NAME_COLUMN = "name";
    public static final String BOOK_ORIGINAL_NAME_COLUMN = "original_name";
    public static final String BOOK_COST_COLUMN = "cost";
    public static final String BOOK_COST_PER_DAY_COLUMN = "cost_per_day";
    public static final String BOOK_YEAR_COLUMN = "year_of_publishing";
    public static final String BOOK_PAGES_COLUMN = "number_of_pages";
    public static final String BOOK_COPIES_NUMBER_COLUMN = "number_of_copies";
    public static final String BOOK_DATE_COLUMN = "registration_date";


    public static final String BOOK_AUTHORS_TABLE = "book_authors";
    public static final String BOOK_GENRES_TABLE = "book_genres";



    public static final String SELECT_ALL_BOOKS = selectAllIsNotDeletedFromTable(BOOK_DESCRIPTIONS_TABLE);
    public static final String SELECT_BOOK_AUTHORS_ID = selectAllFromTableByCriteria(BOOK_AUTHORS_TABLE, BOOK_ID_COLUMN);

    public static final String SELECT_BOOK_GENRES =
            selectAllFromTableJoinTableByCriteria(BOOK_GENRES_TABLE, GENRES_TABLE, GENRE_ID_COLUMN, BOOK_ID_COLUMN);

    public static final String SELECT_BOOK_IMAGES = selectAllFromTableByCriteria(BOOK_DESCRIPTION_IMAGES_TABLE, BOOK_ID_COLUMN);

    public static final String SELECT_BOOK_AUTHORS =
            selectAllFromTableJoinTableByCriteria(BOOK_AUTHORS_TABLE, AUTHORS_TABLE, AUTHOR_ID_COLUMN, BOOK_ID_COLUMN);

//    public static final String SELECT_ALL_BOOKS_WITH_INFO = "SELECT * from book_descriptions inner join " +
//            "book_authors on book_descriptions.book_id = book_authors.book_id inner join " +
//            "authors on book_authors.author_id = authors.author_id inner join " +
//            "book_genres on book_descriptions.book_id = book_genres.book_id inner join " +
//            "genres on book_genres.genre_id = genres.genre_id inner join" +
//            "book_description_images on book_descriptions.book_id = book_description_images.book_id";

    public static final String SELECT_BOOK_BY_ID = selectAllFromTableByCriteria(BOOK_DESCRIPTIONS_TABLE, BOOK_ID_COLUMN);

    public static final String SET_BOOK_DELETED = updateSetDeleted(BOOK_DESCRIPTIONS_TABLE);

    public static final String INSERT_BOOK = "INSERT INTO " + BOOK_DESCRIPTIONS_TABLE +
            " (name, original_name, cost, cost_per_day, year_of_publishing, number_of_pages, number_of_copies, " +
            "registration_date, is_deleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";

    public static final String INSERT_BOOK_AUTHORS =
            insertIntoBookDependent(BOOK_AUTHORS_TABLE, AUTHOR_ID_COLUMN);

    public static final String INSERT_BOOK_GENRES =
            insertIntoBookDependent(BOOK_GENRES_TABLE, GENRE_ID_COLUMN);

    public static final String INSERT_BOOK_DESCRIPTIONS_IMAGES =
            insertIntoBookDependent(BOOK_DESCRIPTION_IMAGES_TABLE, IMAGE_COLUMN);

    public static final String INSERT_BOOK_COPIES = "INSERT INTO " + BOOK_COPIES_TABLE + " (book_id, state_id, availability, is_deleted) " +
            "VALUES (?, ?, ?, ?) RETURNING id";


}
