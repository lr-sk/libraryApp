package com.ita.u1.skomorokhova.libraryApp.consts.db;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.GeneralSql.*;

public class SqlConstsService {

    public static String selectAllFromTable(String tableName) {
        return SELECT_ALL + tableName;
    }

    public static String selectAllIsNotDeletedFromTable(String tableName) {
        return selectAllFromTable(tableName) + " WHERE " + IS_DELETED_FALSE;
    }

    public static String selectAllFromTableByCriteria(String tableName, String criteria) {
        return selectAllFromTable(tableName) + " WHERE " + tableName + "." + criteria + " = ?" +
                " AND " + IS_DELETED_FALSE;
    }

    public static String selectAllFromTableJoinTableByCriteria(String firstTable, String secondTable, String joinColumn, String criteria) {
        return selectAllFromTable(firstTable) +
                " INNER JOIN " + secondTable +
                " ON " + firstTable + "." + joinColumn + " = " + secondTable + "." + joinColumn +
                " WHERE " + firstTable + "." + criteria + " = ?";
    }

    public static String updateSetDeleted(String tableName) {
        return "UPDATE " + tableName + " SET " + TRUE + " WHERE id = ?";
    }

    public static String insertIntoBookDependent(String tableName, String dependentValue) {
        return "INSERT INTO " + tableName + " (book_id, " + dependentValue + ") VALUES (?, ?) RETURNING id";
    }
}
