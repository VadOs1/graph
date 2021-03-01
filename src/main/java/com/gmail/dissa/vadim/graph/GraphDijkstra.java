package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.Map;

public class GraphDijkstra {
    private Map<Vertex, Map<Vertex, Double>> adjacencyVertexesWithCost;

    public GraphDijkstra(Map<Vertex, Map<Vertex, Double>> adjacencyVertexesWithCost) {
        this.adjacencyVertexesWithCost = adjacencyVertexesWithCost;
    }

    public double findShortestPathCost(Vertex v1, Vertex v2) {
        return 0;
    }
}
