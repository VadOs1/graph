package com.gmail.dissa.vadim.graph.model;

import java.util.Objects;

public class AppCell {
    private char c;
    private int x;
    private int y;

    public  AppCell(){
    }

    public AppCell(char c, int y, int x) {
        this.c = c;
        this.y = y;
        this.x = x;
    }

    public char getC() {
        return c;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppCell appCell = (AppCell) o;
        return c == appCell.c && x == appCell.x && y == appCell.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, x, y);
    }
}
