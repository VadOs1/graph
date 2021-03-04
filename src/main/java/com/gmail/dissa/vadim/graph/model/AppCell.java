package com.gmail.dissa.vadim.graph.model;

import java.util.Objects;

public class AppCell {
    private char c;
    private int i;
    private int k;

    public AppCell(char c, int i, int k) {
        this.c = c;
        this.i = i;
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppCell appCell = (AppCell) o;
        return c == appCell.c && i == appCell.i && k == appCell.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, i, k);
    }
}
