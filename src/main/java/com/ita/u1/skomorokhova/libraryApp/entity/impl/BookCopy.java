package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Builder
@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class BookCopy implements Entity {
    long id;
    long bookId;
    long stateId = 1;
    boolean isAvailable = true;
    boolean isDeleted = false;
}
