package com.ita.u1.skomorokhova.libraryApp.entity.builder.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import lombok.extern.log4j.Log4j2;
import lombok.val;
import lombok.var;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ita.u1.skomorokhova.libraryApp.consts.db.AuthorSql.*;

@Log4j2
public class AuthorBuilder implements EntityBuilder<Author> {

    @Override
    public Author buildEntity(ResultSet resultSet) throws SQLException {
        val id = resultSet.getLong(AUTHOR_ID_COLUMN);
        val name = resultSet.getString(AUTHOR_NAME_COLUMN);
        val surname = resultSet.getString(AUTHOR_SURNAME_COLUMN);
        var patronymic = resultSet.getString(AUTHOR_PATRONYMIC_COLUMN);
        val image = resultSet.getString(AUTHOR_IMAGE_COLUMN);
        var fullName = surname + " " + name + " " + patronymic;

        if (patronymic == null) {
            patronymic = "";
            fullName = surname + " " + name;

        }

        return Author.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .patronymic(patronymic)
                .fullName(fullName)
                .image(image)
                .build();
    }
}
