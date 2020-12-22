package com.gmail.dissa.vadim.graph;


import com.gmail.dissa.vadim.graph.model.Node;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class GraphDijkstra {
    private final List<List<Node>> adjacencyList;
    private final int numberOfVertices;
    private final int[] distances;
    private final Set<Integer> settled;
    private final PriorityQueue<Node> priorityQueue;


    public GraphDijkstra(List<List<Node>> adjacencyList) {
        this.adjacencyList = adjacencyList;
        this.numberOfVertices = adjacencyList.size();
        this.distances = new int[numberOfVertices];
        this.settled = new HashSet<>();
        this.priorityQueue = new PriorityQueue<>(numberOfVertices, new Node());
    }

    public int[] dijkstra(int sourceNodeId) {
        for (int i = 0; i < numberOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        priorityQueue.add(new Node(sourceNodeId, 0));
        distances[sourceNodeId] = 0;
        while (!priorityQueue.isEmpty()) {
            int nodeId = priorityQueue.remove().getNodeId();
            settled.add(nodeId);
            processNeighbours(nodeId);
        }
        return distances;
    }


    private void processNeighbours(int nodeId) {
        var adjacencyNodes = adjacencyList.get(nodeId);

        for (Node node : adjacencyNodes) {
            if (!settled.contains(node.getNodeId())) {
                var edgeDistance = node.getCost();
                var newDistance = distances[nodeId] + edgeDistance;

                if (newDistance < distances[node.getNodeId()]) {
                    distances[node.getNodeId()] = newDistance;
                }

                priorityQueue.add(new Node(node.getNodeId(), distances[node.getNodeId()]));
            }
        }
    }
}
