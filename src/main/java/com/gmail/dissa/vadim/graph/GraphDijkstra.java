package com.gmail.dissa.vadim.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GraphDijkstra<T> {
    private Map<T, Map<T, Double>> adjacencyVerticesWithCost;

    public GraphDijkstra() {
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
        // TODO: MAKE FULL COPY OF ADJACENCY VERTICES
        Map<T, Double> costs = createInitialCostsMap(adjacencyVerticesWithCost);
        Map<T, T> parents = createInitialParentsMap(adjacencyVerticesWithCost);
        updateCosts(t1, costs);
        updateParents(t1, parents);
        Set<T> visited = new HashSet<>();
        visited.add(t1);

        T t = getLowestCostVertex(costs, visited);

        while (t != null) {
            visited.add(t);
            //
            //
            t = getLowestCostVertex(costs, visited);;
        }

        return 0.0;
    }

    private Map<T, Double> createInitialCostsMap(Map<T, Map<T, Double>> adjacencyVerticesWithCost) {
        var map = new HashMap<T, Double>();
        adjacencyVerticesWithCost.keySet().forEach(v -> map.put(v, Double.POSITIVE_INFINITY));
        return map;
    }

    private void updateCosts(T t, Map<T, Double> costs) {
        var edges = getEdges(t);
        for (Map.Entry<T, Double> entry : edges.entrySet()) {
            costs.put(entry.getKey(), entry.getValue());
        }
    }

    private Map<T, T> createInitialParentsMap(Map<T, Map<T, Double>> adjacencyVerticesWithCost) {
        var map = new HashMap<T, T>();
        adjacencyVerticesWithCost.keySet().forEach(v -> map.put(v, null));
        return map;
    }

    private void updateParents(T t, Map<T, T> parents) {
        var edges = getEdges(t);
        edges.keySet().forEach(v -> parents.put(v, t));
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
