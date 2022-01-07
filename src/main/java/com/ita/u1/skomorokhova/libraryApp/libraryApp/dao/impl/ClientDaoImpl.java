package com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.ClientDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao {
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
