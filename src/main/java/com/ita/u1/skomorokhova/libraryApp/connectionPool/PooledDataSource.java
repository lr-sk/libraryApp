package com.ita.u1.skomorokhova.libraryApp.connectionPool;

import com.ita.u1.skomorokhova.libraryApp.consts.PathConsts;
import com.ita.u1.skomorokhova.libraryApp.utils.PropertiesReader;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
public class PooledDataSource {
    private static BasicDataSource bds = new BasicDataSource();

    static {
        val properties = PropertiesReader.getProperties(PathConsts.DB_RESOURCE_FILE_NAME);

        if (properties.size() != 0) {
            val url = properties.getProperty("db.url");
            val driverClassName = properties.getProperty("db.driverClassName");
            val user = properties.getProperty("db.user");
            val pass = properties.getProperty("db.password");
            val minIdle = PropertiesReader.castPropToInt(properties.getProperty("db.minIdle"));
            val maxIdle = PropertiesReader.castPropToInt(properties.getProperty("db.maxIdle"));
            val maxTotal = PropertiesReader.castPropToInt(properties.getProperty("db.maxTotal"));
            val initialSize = PropertiesReader.castPropToInt(properties.getProperty("db.initialSize"));

            bds.setUrl(url);
            bds.setDriverClassName(driverClassName);
            bds.setUsername(user);
            bds.setPassword(pass);
            bds.setMinIdle(minIdle);
            bds.setMaxIdle(maxIdle);
            bds.setMaxTotal(maxTotal);
            bds.setInitialSize(initialSize);
        }
    }

    public static Connection getConnection() throws SQLException {
        return bds.getConnection();
    }

    private PooledDataSource() {

    }
}
