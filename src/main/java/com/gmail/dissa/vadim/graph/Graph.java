package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Graph {

    private Map<Vertex, List<Vertex>> adjacencyVertexes;

    public Graph() {
        adjacencyVertexes = new ConcurrentHashMap<>();
        print();
    }

    public void addVertex(Vertex vertex) {
        if (vertex == null) {
            throw new NullPointerException("Can not add null vertex");
        }
        adjacencyVertexes.putIfAbsent(vertex, new LinkedList<>());
    }

    public void removeVertex(Vertex vertex) {
        if (vertex == null) {
            throw new NullPointerException("Can not remove null vertex");
        }
        adjacencyVertexes.keySet().remove(vertex);
    }

    public void createEdge(Vertex from, Vertex to) {
        addVertex(from);
        addVertex(to);
        adjacencyVertexes.get(from).add(to);
    }

    public int getSize() {
        return adjacencyVertexes.size();
    }

    public List<Vertex> getEdges(Vertex vertex) {
        return adjacencyVertexes.get(vertex);
    }

    private void print() {
        for (Map.Entry<Vertex, List<Vertex>> entry : adjacencyVertexes.entrySet()) {
            System.out.print("Vertex = " + entry.getKey() + ". Edges: ");
            entry.getValue().forEach(System.out::print);
            System.out.println();
        }
    }
}
