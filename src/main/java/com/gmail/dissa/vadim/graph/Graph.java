package com.gmail.dissa.vadim.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<T> {
    private final Map<T, Set<T>> adjacencyVertices;
    private final Set<T> vertices;

    public Graph() {
        adjacencyVertices = new HashMap<>();
        vertices = new HashSet<>();
    }

    /**
     * Constructs a new package and dependencies
     *
     * @param t   new package
     * @param set package dependencies
     * @return {@code true} if package was successfully added
     * @throws IllegalArgumentException if package is not provided /
     *                                  package has dependency on itself
     */
    public synchronized boolean addPackage(T t, Set<T> set) {
        if (t == null) {
            throw new IllegalArgumentException("Package not provided");
        }
        if (set == null) {
            set = new HashSet<>();
        }
        if (set.contains(t)) {
            throw new IllegalArgumentException("Package can not have dependency on itself");
        }

        addVertex(t);
        Set<T> edges = adjacencyVertices.get(t);
        for (T t1 : set) {
            addVertex(t1);
            edges.add(t1);
        }
        return true;
    }

    /**
     * Removes a package and dependencies
     *
     * @param t package
     * @return {@code true} if package was successfully removed
     * @throws IllegalArgumentException if package doesn't exist
     */
    public synchronized boolean removePackage(T t) {
        if (adjacencyVertices.get(t) == null) {
            throw new IllegalArgumentException("Package doesn't exist");
        }

        if (isReferenced(t)) {
            return false;
        } else {
            Set<T> edges = adjacencyVertices.get(t);
            adjacencyVertices.keySet().remove(t);
            vertices.remove(t);
            for (T edge : edges) {
                removePackage(edge);
            }
            return true;
        }
    }

    /**
     * Gets a copy of adjacency vertices. Only a map containing T to Set<T> references is copied.
     * Objects immutability should be handled externally in T class if needed
     *
     * @return adjacency vertices
     */
    public Map<T, Set<T>> getGraph() {
        return new HashMap<>(adjacencyVertices);
    }

    /**
     * Gets a set of all vertices. Objects immutability should be handled externally in T class if needed
     *
     * @return all vertices
     */
    public Set<T> getVertices() {
        return new HashSet<>(vertices);
    }

    private void addVertex(T t) {
        adjacencyVertices.putIfAbsent(t, new HashSet<>());
        vertices.add(t);
    }

    private boolean isReferenced(T t) {
        for (Map.Entry<T, Set<T>> entry : adjacencyVertices.entrySet()) {
            if (entry.getValue().contains(t)) {
                return true;
            }
        }
        return false;
    }
}
