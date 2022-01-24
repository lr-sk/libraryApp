package com.ita.u1.skomorokhova.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.dao.ClientDao;
import com.ita.u1.skomorokhova.libraryApp.entity.builder.EntityBuilder;
import com.ita.u1.skomorokhova.libraryApp.entity.impl.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao {

    public EntityBuilder<Client> getEntityBuilder() {
        return null;
    }

    @Override
    public Client findEntityById(Long id) {
        return null;
    }

    @Override
    public boolean delete(Client client) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean create(Client client) {
        return false;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findBookByName(String name) {
        return null;
    }

    @Override
    public List<Client> findBookBySurname(String originalName) {
        return null;
    }

    @Override
    public List<Client> findBookByPassportId(int year) {
        return null;
    }
}
