package com.gmail.dissa.vadim.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Graph<T> {

    private Map<T, List<T>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
    }

    public int getSize() {
        return adjacencyVertexes.size();
    }

    public void addVertex(T t) {
        adjacencyVertexes.putIfAbsent(t, new ArrayList<>());
    }

    public void removeVertex(T t) {
        adjacencyVertexes.keySet().remove(t);
    }
}
