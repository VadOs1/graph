package com.gmail.dissa.vadim.graph;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Implementation:
 * - get packages and dependent packages
 * - create objects for each package
 * - call add vertex for each package
 * - call createEdge for each package - dependent
 * - call removeVertexWithUsageCheck when package needs to be deleted
 */
public class Graph<T> {
    private final Map<T, Set<T>> adjacencyVertices;

    public Graph() {
        adjacencyVertices = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVertices.putIfAbsent(t, ConcurrentHashMap.newKeySet());
    }

    public void createEdge(T from, T to) {
        Set<T> edgesFrom = adjacencyVertices.get(from);
        if (edgesFrom == null) {
            throw new IllegalArgumentException("From doesn't exist");
        }

        Set<T> edgesTo = adjacencyVertices.get(to);
        if (edgesTo == null) {
            throw new IllegalArgumentException("To doesn't exist");
        }
        edgesFrom.add(to);
    }

    public Set<T> getEdges(T t) {
        return adjacencyVertices.get(t);
    }

    public int getVertexCount() {
        return adjacencyVertices.size();
    }

    public boolean removeVertexWithUsageCheck(T t) {
        if (isReferenced(t)) {
            return false;
        } else {
            Set<T> edges = getEdges(t);
            adjacencyVertices.keySet().remove(t);
            for (T edge : edges) {
                removeVertexWithUsageCheck(edge);
            }
            return true;
        }
    }

    private boolean isReferenced(T t) {
        for (Map.Entry<T, Set<T>> entry : adjacencyVertices.entrySet()) {
            if (!entry.getKey().equals(t) && entry.getValue().contains(t)) {
                return true;
            }
        }
        return false;
    }
}
