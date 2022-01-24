package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.connectionPool.PooledDataSource;
import com.ita.u1.skomorokhova.libraryApp.dao.ImageDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Image;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.ImageSql.IMAGE_COLUMN;
import static com.ita.u1.skomorokhova.libraryApp.consts.db.ImageSql.IMAGE_ID_COLUMN;

public class ImageDaoImpl implements ImageDao {
    @Override
    public List<Image> findAll() {
        return null;
    }

    @Override
    public Image findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Image image) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Image image) {
        return false;
    }

    @Override
    public Image update(Image image) {
        return null;
    }

    public List<Image> findAllByBookId(Long bookId, String query) {
        val valuesList = new ArrayList<Image>();

        try (val connection = getConnection();
             val preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setLong(1, bookId);

            try (val resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    val id = resultSet.getLong(IMAGE_ID_COLUMN);
                    val imageString = resultSet.getString(IMAGE_COLUMN);

                    val image = Image.builder()
                            .id(id)
                            .imageString(imageString)
                            .build();

                    valuesList.add(image);
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return valuesList;

    }

    private Connection getConnection() {
        try {
            return PooledDataSource.getConnection();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
