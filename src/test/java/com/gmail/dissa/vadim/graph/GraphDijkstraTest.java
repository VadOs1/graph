package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class GraphDijkstraTest {

    @Test
    public void testShouldRemoveVertexAndReturnCorrectVertexCount() {
        var graphDijkstra = new GraphDijkstra<>();
        assertEquals(0, graphDijkstra.getVertexCount());
        var v1 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        graphDijkstra.removeVertex(v1);
        assertEquals(0, graphDijkstra.getVertexCount());
    }

    @Test
    public void textShouldAddVertexAndReturnCorrectVertexCount() {
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
    public void testShouldCreateAndGetEdges() {
        var graphDijkstra = new GraphDijkstra<>();
        var v1 = new Vertex(UUID.randomUUID());
        var v2 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        graphDijkstra.addVertex(v2);
        graphDijkstra.createEdge(v1, v2, 1.0);
        assertEquals(2, graphDijkstra.getVertexCount());
        var v1Edges = graphDijkstra.getEdges(v1);
        assertEquals(1, v1Edges.size());
        assertEquals(1.0, v1Edges.get(v2), 0);
    }


    @Test
    public void testShouldFindShortestPathCost() {
        var graphDijkstra = new GraphDijkstra<>();
        var distanceCost = graphDijkstra.findShortestPathCost(new Vertex(UUID.randomUUID()), new Vertex(UUID.randomUUID()));
        assertEquals(0, distanceCost, 0);
    }
}
