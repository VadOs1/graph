package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GraphDijkstraTest {
    @Test
    void shouldPrintDistances() {
        assertDoesNotThrow(() -> {
            List<List<Node>> adjacencyList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                List<Node> item = new ArrayList<>();
                adjacencyList.add(item);
            }
            adjacencyList.get(0).add(new Node(1, 9));
            adjacencyList.get(0).add(new Node(2, 6));
            adjacencyList.get(0).add(new Node(3, 5));
            adjacencyList.get(0).add(new Node(4, 3));
            adjacencyList.get(2).add(new Node(1, 2));
            adjacencyList.get(2).add(new Node(3, 4));

            GraphDijkstra dpq = new GraphDijkstra(adjacencyList);
            var distances = dpq.dijkstra(0);
            print(distances);
        });
    }

    private void print(int[] distances) {
        System.out.println("The shorted path from node :");
        for (int i = 0; i < distances.length; i++)
            System.out.println(0 + " to " + i + " is " + distances[i]);
    }
}
