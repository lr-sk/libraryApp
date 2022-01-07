package com.ita.u1.skomorokhova.libraryApp.libraryApp.consts;

public class SqlConsts {
    public static final String SELECT_ALL = "SELECT * FROM";
    public static final String SELECT_ALL_BOOKS = SELECT_ALL + " books";
    public static final String SELECT_ALL_BOOKS_BY_CRITERIA = SELECT_ALL_BOOKS + " WHERE";
    public static final String SELECT_BOOK_BY_ID = SELECT_ALL_BOOKS_BY_CRITERIA + " id = ?";
}
