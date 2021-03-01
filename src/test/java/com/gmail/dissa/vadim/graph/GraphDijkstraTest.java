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
        graphDijkstra.createEdge(v1, v2, 2.0);
        assertEquals(2, graphDijkstra.getVertexCount());
        var v1Edges = graphDijkstra.getEdges(v1);
        assertEquals(1, v1Edges.size());
        assertEquals(2.0, v1Edges.get(v2), 0);
    }


    @Test
    public void testShouldFindShortestPathCost() {
        // GIVEN
        var graphDijkstra = new GraphDijkstra<>();

        // WHEN
        var v1 = new Vertex(UUID.randomUUID());
        var v2 = new Vertex(UUID.randomUUID());
        var v3 = new Vertex(UUID.randomUUID());
        var v4 = new Vertex(UUID.randomUUID());
        var v5 = new Vertex(UUID.randomUUID());
        var v6 = new Vertex(UUID.randomUUID());
        var v7 = new Vertex(UUID.randomUUID());
        var v8 = new Vertex(UUID.randomUUID());
        var v9 = new Vertex(UUID.randomUUID());
        var v10 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        graphDijkstra.addVertex(v2);
        graphDijkstra.addVertex(v3);
        graphDijkstra.addVertex(v4);
        graphDijkstra.addVertex(v5);
        graphDijkstra.addVertex(v6);
        graphDijkstra.addVertex(v7);
        graphDijkstra.addVertex(v8);
        graphDijkstra.addVertex(v9);
        graphDijkstra.addVertex(v10);
        graphDijkstra.createEdge(v1, v2, 1.0);
        graphDijkstra.createEdge(v2, v3, 1.0);
        graphDijkstra.createEdge(v3, v4, 1.0);
        graphDijkstra.createEdge(v1, v5, 1.0);
        graphDijkstra.createEdge(v5, v6, 1.0);
        graphDijkstra.createEdge(v5, v7, 1.0);
        graphDijkstra.createEdge(v7, v8, 1.0);
        graphDijkstra.createEdge(v8, v9, 1.0);
        graphDijkstra.createEdge(v9, v8, 1.0);

        // THEN
        var distanceCost = graphDijkstra.findShortestPathCost(v1, v9);
        assertEquals(4.0, distanceCost, 0);
    }
}
