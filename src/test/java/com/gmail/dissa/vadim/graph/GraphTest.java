package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {

    @Test
    public void testInitialSizeOfGraphShouldBeZero() {
        var graph = new Graph<>();
        assertEquals(0, graph.getSize());
    }

    @Test
    public void testShouldThrowNullPointerExceptionWhenAddingNullVertex() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<>();
            graph.addVertex(null);
        });
    }

    @Test
    public void testShouldThrowNullPointerExceptionWhenRemovingNullVertex() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<>();
            assertEquals(0, graph.getSize());
            graph.removeVertex(null);
        });
    }

    @Test
    public void testShouldAddVertex() {
        var graph = new Graph<>();
        var vertex = new Vertex(0L);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddTwoVertices() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    public void testShouldAddThreeVertices() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        var vertex3 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
    }

    @Test
    public void testShouldAddVertexWithIdNullOnlyOnce() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(null);
        var vertex2 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldDeleteNothingFromEmptyGraph() {
        var graph = new Graph<>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(0L));
        assertEquals(0, graph.getSize());
    }

    @Test
    public void testShouldDeleteFromGraph() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        var vertex3 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
        graph.removeVertex(new Vertex(0L));
        assertEquals(2, graph.getSize());
    }

    @Test
    public void testShouldDeleteNothingFromEmptyGraphWithIdNull() {
        var graph = new Graph<>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(null));
        assertEquals(0, graph.getSize());
    }

    @Test
    public void testShouldDeleteFromGraphWithIdNull() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        var vertex3 = new Vertex(null);
        var vertex4 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addVertex(vertex4);
        assertEquals(3, graph.getSize());
        graph.removeVertex(new Vertex(null));
        assertEquals(2, graph.getSize());
    }

    @Test
    public void testShouldCreateAndReturnEdges() {
        var graph = new Graph<>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        graph.createEdge(vertex1, vertex2);
        assertEquals(2, graph.getSize());
        var vertex1Edges = graph.getEdges(vertex1);
        assertNotNull(vertex1Edges);
        assertEquals(1, vertex1Edges.size());
        assertEquals(vertex2, vertex1Edges.get(0));
    }
}
