package com.ita.u1.skomorokhova.libraryApp.dao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Image;

import java.util.List;

public interface ImageDao extends BaseDao<Long, Image>{
    List<Image> findAllByBookId(Long bookId, String query);
}
