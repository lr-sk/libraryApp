package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.AuthorDao;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Entity;

import java.util.List;

public class AuthorDaoImpl implements AuthorDao {
    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Entity findEntityById(Object id) {
        return null;
    }

    @Override
    public boolean delete(Entity entity) {
        return false;
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public boolean create(Entity entity) {
        return false;
    }

    @Override
    public Entity update(Entity entity) {
        return null;
    }
}
