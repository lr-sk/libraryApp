package com.ita.u1.skomorokhova.libraryApp.libraryApp.dao;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Author;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Book;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Client;
import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl.Genre;

import java.util.List;

public interface ClientDao extends BaseDao<Long, Client> {
    List<Client> findAll();
    List<Client> findBookByName(String name);
    List<Client> findBookBySurname(String originalName);
    List<Client> findBookByPassportId(int year);
}
