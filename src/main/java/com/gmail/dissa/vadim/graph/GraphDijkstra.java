package com.gmail.dissa.vadim.graph;

import java.util.*;
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
        // add initial costs map
        Map<T, Double> costs = new HashMap<>();
        adjacencyVerticesWithCost.keySet().forEach(v -> costs.put(v, Double.POSITIVE_INFINITY));

        // add initial parents map
        Map<T, T> parents = new HashMap<>();
        adjacencyVerticesWithCost.keySet().forEach(v -> parents.put(v, null));

        // add set to store visited elements
        Set<T> visited = new HashSet<>();

        // send element to the queue
        PriorityQueue<T> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(t1, 1);


        while (!priorityQueue.isEmpty()) {
            T t  = priorityQueue.poll();
            visited.add(t);
            updateCostsAndParents(t, costs, parents, priorityQueue);
        }

        return getCost(t1, t2, costs, parents);
    }

    private void updateCostsAndParents(T t, Map<T, Double> costs, Map<T, T> parents, PriorityQueue<T> priorityQueue) {
        var edges = getEdges(t);
        for (Map.Entry<T, Double> entry : edges.entrySet()) {
            var currentCost = costs.get(entry.getKey());
            if (currentCost > entry.getValue()) {
                costs.put(entry.getKey(), entry.getValue());
                parents.put(entry.getKey(), t);
                priorityQueue
            }
        }
    }

    private double getCost(T from, T to, Map<T, Double> costs, Map<T, T> parents) {
        double totalCost = 0;
        var targetNode = to;
        while (targetNode != null) {
            var parent = parents.get(targetNode);
            var cost = costs.get(targetNode);
            if (targetNode == from) {
                targetNode = null;
            } else {
                totalCost += cost;
                targetNode = parent;
            }
        }
        return totalCost;
    }
}
