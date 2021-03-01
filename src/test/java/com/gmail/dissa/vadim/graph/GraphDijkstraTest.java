package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class GraphDijkstraTest {

    @Test
    public void testShouldFindShortestPathCost() {
        var graphDijkstra = new GraphDijkstra<>();
        var distanceCost = graphDijkstra.findShortestPathCost(new Vertex(UUID.randomUUID()), new Vertex(UUID.randomUUID()));
        assertEquals(0, distanceCost, 0);
    }
}
