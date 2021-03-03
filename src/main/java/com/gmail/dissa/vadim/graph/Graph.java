package com.gmail.dissa.vadim.graph;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Graph<T> {

    private Map<T, Set<T>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVertexes.putIfAbsent(t, ConcurrentHashMap.newKeySet());
    }

    public void removeVertex(T t) {
        adjacencyVertexes.keySet().remove(t);
    }

    public void createEdge(T from, T to) {
        adjacencyVertexes.get(from).add(to);
    }

    public Set<T> getEdges(T t) {
        return adjacencyVertexes.get(t);
    }

    public int getVertexCount() {
        return adjacencyVertexes.size();
    }

    public boolean isReferenced(T t) {
        for (Map.Entry<T, Set<T>> entry : adjacencyVertexes.entrySet()) {
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
                removeVertexWithUsageCheck(t);
            }
            return true;
        }
    }
}
