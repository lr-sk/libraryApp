package com.ita.u1.skomorokhova.libraryApp.dao;

import com.ita.u1.skomorokhova.libraryApp.entity.impl.Client;

import java.util.List;

public interface ClientDao extends BaseDao<Long, Client> {
    List<Client> findAll();
    List<Client> findBookByName(String name);
    List<Client> findBookBySurname(String originalName);
    List<Client> findBookByPassportId(int year);
}
