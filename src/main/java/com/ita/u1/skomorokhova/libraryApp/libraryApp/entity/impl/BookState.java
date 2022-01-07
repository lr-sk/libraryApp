package com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.impl;

import com.ita.u1.skomorokhova.libraryApp.libraryApp.entity.Entity;

public enum BookState implements Entity {
    GOOD (0),
    SLIGHT_DAMAGE (0.1),
    MEDIUM_DAMAGE (0.5),
    SEVERE_DAMAGE (1);

    private double fineFactor;

    BookState(double fineFactor) {
        this.fineFactor = fineFactor;
    }

    public double getFinePercent() {
        return fineFactor;
    }
}
