package com.ita.u1.skomorokhova.libraryApp.dao;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.NonNull;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.Errors.*;

public interface BaseDao <K, T extends Entity> {

    org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger();

    List<T> findAll();
    T findEntityById(K id);
    boolean delete(T t);
    boolean delete(K id);
    boolean create(T t);
    T update(T t);

    default void close(@NonNull ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            log.error(CANNOT_CLOSE_RESULT_SET);
        }
    }

    default void close(@NonNull Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            log.error(CANNOT_CLOSE_STATEMENT);
        }
    }

    default void close(@NonNull Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            log.error(CANNOT_CLOSE_CONNECTION);
        }
    }

}
