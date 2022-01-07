package com.ita.u1.skomorokhova.libraryApp.libraryApp.service.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.dao.ClientDao;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Client;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.service.EntityService;

import java.util.List;

public class ClientService implements EntityService<Client> {
    ClientDao dao;

    public ClientService(ClientDao dao) {
        this.dao = dao;
    }

    @Override
    public List getAll() {
        return null;
    }
}
