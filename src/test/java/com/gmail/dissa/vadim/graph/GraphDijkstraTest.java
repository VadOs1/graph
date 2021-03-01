package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;


public class GraphDijkstraTest {

    @Test
    public void testShouldFindShortestPathCost() {
        Map<Vertex, Map<Vertex, Double>> adjacencyVertexesWithCost = new ConcurrentHashMap<>();
        var graphDijkstra = new GraphDijkstra(adjacencyVertexesWithCost);
        var distanceCost = graphDijkstra.findShortestPathCost(new Vertex(UUID.randomUUID()), new Vertex(UUID.randomUUID()));
        assertEquals(0, distanceCost, 0);
    }
}
