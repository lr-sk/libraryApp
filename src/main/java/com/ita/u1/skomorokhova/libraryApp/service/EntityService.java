package com.ita.u1.skomorokhova.libraryApp.service;


import com.ita.u1.skomorokhova.libraryApp.entity.impl.Entity;

import java.util.List;

public interface EntityService <T extends Entity> {
    List<T> getAll();
}
