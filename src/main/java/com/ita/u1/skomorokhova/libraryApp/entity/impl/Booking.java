package com.ita.u1.skomorokhova.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.entity.Entity;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Booking implements Entity {
    private long id;
}
