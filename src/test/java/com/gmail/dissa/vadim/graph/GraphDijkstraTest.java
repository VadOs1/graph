package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class GraphDijkstraTest {

    @Test
    public void shouldAddVertexAndReturnCorrectVertexCount(){
        var graphDijkstra = new GraphDijkstra<>();
        assertEquals(0, graphDijkstra.getVertexCount());
        var v1 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        var v2 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v2);
        assertEquals(2, graphDijkstra.getVertexCount());

    }

    @Test
    public void testShouldFindShortestPathCost() {
        var graphDijkstra = new GraphDijkstra<>();
        var distanceCost = graphDijkstra.findShortestPathCost(new Vertex(UUID.randomUUID()), new Vertex(UUID.randomUUID()));
        assertEquals(0, distanceCost, 0);
    }
}
