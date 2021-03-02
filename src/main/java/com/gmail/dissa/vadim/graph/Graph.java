package com.gmail.dissa.vadim.graph;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Graph<T> {

    private Map<T, List<T>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVertexes.putIfAbsent(t, new CopyOnWriteArrayList<>());
    }

    public void removeVertex(T t) {
        adjacencyVertexes.keySet().remove(t);
    }

    public void createEdge(T from, T to) {
        adjacencyVertexes.get(from).add(to);
    }

    public List<T> getEdges(T t) {
        return adjacencyVertexes.get(t);
    }

    public int getVertexCount() {
        return adjacencyVertexes.size();
    }
}
