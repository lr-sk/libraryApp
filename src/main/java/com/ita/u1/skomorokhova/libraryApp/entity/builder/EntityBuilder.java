package com.ita.u1.skomorokhova.libraryApp.entity.builder;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityBuilder <T extends Entity> {
     T buildEntity(ResultSet resultSet) throws SQLException;
}
