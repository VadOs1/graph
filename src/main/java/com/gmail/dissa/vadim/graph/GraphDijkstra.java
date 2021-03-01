package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDijkstra<T> {
    private Map<T, Map<T, Double>> adjacencyVertexesWithCost;

    public GraphDijkstra() {
        this.adjacencyVertexesWithCost = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVertexesWithCost.putIfAbsent(t, new ConcurrentHashMap<>());
    }

    public void removeVertex(T t) {
        adjacencyVertexesWithCost.keySet().remove(t);
    }

    public int getVertexCount() {
        return adjacencyVertexesWithCost.size();
    }

    public double findShortestPathCost(Vertex v1, Vertex v2) {
        return 0;
    }
}
