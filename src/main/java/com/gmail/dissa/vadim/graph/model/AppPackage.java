package com.gmail.dissa.vadim.graph.model;

import java.util.Objects;

/**
 * The {@code AppPackage} class represents program packages.
 *
 * @implNote Immutable
 */
public class AppPackage {
    private String name;

    public AppPackage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AppPackage setName(String name) {
        return new AppPackage(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppPackage aPackage = (AppPackage) o;
        return Objects.equals(name, aPackage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
