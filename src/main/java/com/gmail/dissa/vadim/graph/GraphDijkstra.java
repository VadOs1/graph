package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDijkstra<T> {
    private Map<T, Map<T, Double>> adjacencyVertexesWithCost;

    public GraphDijkstra() {
        this.adjacencyVertexesWithCost = new ConcurrentHashMap<>();
    }

    public double findShortestPathCost(Vertex v1, Vertex v2) {
        return 0;
    }
}
