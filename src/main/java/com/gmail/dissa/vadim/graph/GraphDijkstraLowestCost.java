package com.gmail.dissa.vadim.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDijkstraLowestCost<T> {
    private Map<T, Map<T, Double>> adjacencyVerticesWithCost;

    public GraphDijkstraLowestCost() {
        this.adjacencyVerticesWithCost = new ConcurrentHashMap<>();
    }

    public void addVertex(T t) {
        adjacencyVerticesWithCost.putIfAbsent(t, new ConcurrentHashMap<>());
    }

    public void removeVertex(T t) {
        adjacencyVerticesWithCost.keySet().remove(t);
    }

    public void createEdge(T from, T to, Double cost) {
        adjacencyVerticesWithCost.get(from).put(to, cost);
    }

    public Map<T, Double> getEdges(T t) {
        return adjacencyVerticesWithCost.get(t);
    }

    public int getVertexCount() {
        return adjacencyVerticesWithCost.size();
    }

    public double findShortestPathCost(T t1, T t2) {
        // add initial costs map
        Map<T, Double> costs = new HashMap<>();
        adjacencyVerticesWithCost.keySet().forEach(v -> costs.put(v, Double.POSITIVE_INFINITY));

        // add initial parents map
        Map<T, T> parents = new HashMap<>();
        adjacencyVerticesWithCost.keySet().forEach(v -> parents.put(v, null));

        // process root element
        costs.put(t1, 0.0);
        updateCostsAndParents(t1, costs, parents);

        // mark parent as visited
        Set<T> visited = new HashSet<>();
        visited.add(t1);

        // process
        T t = getLowestCostVertex(costs, visited);
        while (t != null) {
            visited.add(t);
            updateCostsAndParents(t, costs, parents);
            t = getLowestCostVertex(costs, visited);
        }

        return costs.get(t2);
    }

    private void updateCostsAndParents(T t, Map<T, Double> costs, Map<T, T> parents) {
        var currentCost = costs.get(t);
        var edges = getEdges(t);
        for (Map.Entry<T, Double> entry : edges.entrySet()) {
            var costToCheck = currentCost + entry.getValue();
            if (costs.get(entry.getKey()) > costToCheck) {
                costs.put(entry.getKey(), costToCheck);
                parents.put(entry.getKey(), t);
            }
        }
    }

    private T getLowestCostVertex(Map<T, Double> costsMap, Set<T> visited) {
        var lowestCost = Double.POSITIVE_INFINITY;
        T lowestCostVertex = null;

        for (Map.Entry<T, Double> entry : costsMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (!visited.contains(key) && value < lowestCost) {
                lowestCost = value;
                lowestCostVertex = key;
            }
        }

        return lowestCostVertex;
    }
}
