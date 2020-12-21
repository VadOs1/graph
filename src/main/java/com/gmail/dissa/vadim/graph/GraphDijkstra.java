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

    public void dijkstra(int sourceNodeId) {
        for (int i = 0; i < numberOfVertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        priorityQueue.add(new Node(sourceNodeId, 0));
        distances[sourceNodeId] = 0;
        while (settled.size() != numberOfVertices) {
            int nodeId = priorityQueue.remove().getNodeId();
            settled.add(nodeId);
            processNeighbours(nodeId);
        }
        print();
    }


    private void processNeighbours(int nodeId) {
        var adjacencyNodes = adjacencyList.get(nodeId);
        var edgeDistance = -1;
        var newDistance = -1;

        for (Node v : adjacencyNodes) {
            if (!settled.contains(v.getNodeId())) {
                edgeDistance = v.getCost();
                newDistance = distances[nodeId] + edgeDistance;

                if (newDistance < distances[v.getNodeId()])
                    distances[v.getNodeId()] = newDistance;

                priorityQueue.add(new Node(v.getNodeId(), distances[v.getNodeId()]));
            }
        }
    }

    private void print() {
        System.out.println("The shorted path from node :");
        for (int i = 0; i < distances.length; i++)
            System.out.println(0 + " to " + i + " is " + distances[i]);
    }
}
