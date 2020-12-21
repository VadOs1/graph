package com.gmail.dissa.vadim.graph;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class Graph<T> {

    protected Map<T, Set<T>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
        print();
    }

    public void addVertex(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Can not add null vertex");
        }
        adjacencyVertexes.putIfAbsent(t, new CopyOnWriteArraySet<>());
    }

    public void removeVertex(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Can not remove null vertex");
        }
        adjacencyVertexes.keySet().remove(t);
    }

    public void createEdge(T from, T to) {
        addVertex(from);
        addVertex(to);
        adjacencyVertexes.get(from).add(to);
    }

    public void removeEdge(T from, T to) {
        adjacencyVertexes.get(from).remove(to);
    }

    public int getSize() {
        return adjacencyVertexes.size();
    }

    public Set<T> getEdges(T t) {
        return adjacencyVertexes.get(t);
    }

    protected void print() {
        for (Map.Entry<T, Set<T>> entry : adjacencyVertexes.entrySet()) {
            System.out.print("Vertex = " + entry.getKey() + ". Edges: ");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }
    }
}
