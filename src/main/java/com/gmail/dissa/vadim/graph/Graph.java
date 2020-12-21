package com.gmail.dissa.vadim.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Graph<T> {

    protected Map<T, List<T>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
        print();
    }

    public void addVertex(T t) {
        if (t == null) {
            throw new NullPointerException("Can not add null vertex");
        }
        adjacencyVertexes.putIfAbsent(t, new LinkedList<>());
    }

    public void removeVertex(T t) {
        if (t == null) {
            throw new NullPointerException("Can not remove null vertex");
        }
        adjacencyVertexes.keySet().remove(t);
    }

    public void createEdge(T from, T to) {
        addVertex(from);
        addVertex(to);
        adjacencyVertexes.get(from).add(to);
    }

    public int getSize() {
        return adjacencyVertexes.size();
    }

    public List<T> getEdges(T t) {
        return adjacencyVertexes.get(t);
    }

    protected void print() {
        for (Map.Entry<T, List<T>> entry : adjacencyVertexes.entrySet()) {
            System.out.print("Vertex = " + entry.getKey() + ". Edges: ");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }
    }
}
