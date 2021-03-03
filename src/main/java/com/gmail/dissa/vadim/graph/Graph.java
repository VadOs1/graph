package com.gmail.dissa.vadim.graph;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Graph<T> {

    private Map<T, Set<T>> adjacencyVertices;

    public Graph() {
        adjacencyVertices = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVertices.putIfAbsent(t, ConcurrentHashMap.newKeySet());
    }

    public void removeVertex(T t) {
        adjacencyVertices.keySet().remove(t);
    }

    public void createEdge(T from, T to) {
        adjacencyVertices.get(from).add(to);
    }

    public Set<T> getEdges(T t) {
        return adjacencyVertices.get(t);
    }

    public int getVertexCount() {
        return adjacencyVertices.size();
    }

    public boolean isReferenced(T t) {
        for (Map.Entry<T, Set<T>> entry : adjacencyVertices.entrySet()) {
            if (!entry.getKey().equals(t) && entry.getValue().contains(t)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeVertexWithUsageCheck(T t) {
        if (isReferenced(t)) {
            return false;
        } else {
            Set<T> edges = getEdges(t);
            removeVertex(t);
            for (T edge : edges) {
                removeVertexWithUsageCheck(edge);
            }
            return true;
        }
    }
}
