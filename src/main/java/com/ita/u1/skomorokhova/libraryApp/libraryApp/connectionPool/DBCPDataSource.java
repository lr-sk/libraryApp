package com.ita.u1.skomorokhova.libraryApp.libraryApp.connectionPool;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.consts.DatabaseConsts;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.utils.PropertiesReader;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Log4j2
public class DBCPDataSource {
    private static BasicDataSource ds = new BasicDataSource();

    static {
        val properties = PropertiesReader.getProperties(DatabaseConsts.DB_RESOURCE_FILE_NAME);

        if (properties.size() != 0) {
            val url = properties.getProperty("db.url");
            val user = properties.getProperty("db.user");
            val pass = properties.getProperty("db.password");
            val minIdle = PropertiesReader.castPropToInt(properties.getProperty("db.minIdle"));
            val maxIdle = PropertiesReader.castPropToInt(properties.getProperty("db.maxIdle"));
            val maxOpenPreparedStatements = PropertiesReader.castPropToInt(properties.getProperty("db.maxOpenPreparedStatements"));

            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(pass);
            ds.setMinIdle(minIdle);
            ds.setMaxIdle(maxIdle);
            ds.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        }
    }

    public static Connection getConnection() throws SQLException {
        log.error("Getting connection from connection pool");
        return ds.getConnection();
    }

    private DBCPDataSource() {

    }
}
