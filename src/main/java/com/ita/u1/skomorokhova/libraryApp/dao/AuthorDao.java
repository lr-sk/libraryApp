package com.ita.u1.skomorokhova.libraryApp.dao;

import com.ita.u1.skomorokhova.libraryApp.entity.impl.Author;
import java.util.List;

public interface AuthorDao extends BaseDao<Long, Author> {
    List<Author> findAllByBookId(Long bookId, String query);

}
