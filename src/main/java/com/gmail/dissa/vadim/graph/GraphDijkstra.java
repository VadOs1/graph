package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.HashMap;
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

    public void createEdge(T from, T to, Double cost) {
        adjacencyVertexesWithCost.get(from).put(to, cost);
    }

    public Map<T, Double> getEdges(T t) {
        return adjacencyVertexesWithCost.get(t);
    }

    public int getVertexCount() {
        return adjacencyVertexesWithCost.size();
    }

    public double findShortestPathCost(Vertex v1, Vertex v2) {
        Map<T, Double> costs = new HashMap<>();
        Map<T, T> parents = new HashMap<>();
        return 0.0;
    }
}
