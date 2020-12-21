package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {

    @Test
    void shouldCreateEmptyGraphTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldThrowExceptionWhenAddingNullVertexTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            var graph = new Graph<Vertex>();
            graph.addVertex(null);
        });
    }

    @Test
    void shouldThrowExceptionWhenRemovingNullVertexTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            var graph = new Graph<Vertex>();
            assertEquals(0, graph.getSize());
            graph.removeVertex(null);
        });
    }

    @Test
    void shouldAddVertexTest() {
        var graph = new Graph<Vertex>();
        var vertex = new Vertex(UUID.randomUUID());
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldAddTwoVerticesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(UUID.randomUUID());
        var vertex2 = new Vertex(UUID.randomUUID());
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    void shouldAddThreeVerticesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(UUID.randomUUID());
        var vertex2 = new Vertex(UUID.randomUUID());
        var vertex3 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
    }

    @Test
    void shouldAddVertexWithNullsOnlyOnceTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(null);
        var vertex2 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldDeleteNothingFromEmptyGraphTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(UUID.randomUUID()));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldDeleteFromGraphTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(UUID.randomUUID());
        var vertex2 = new Vertex(null);
        var vertex3 = new Vertex(UUID.randomUUID());
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
        graph.removeVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    void shouldDeleteNothingFromEmptyGraphWithNullsTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(null));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldCreateAndReturnEdgesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(UUID.randomUUID());
        var vertex2 = new Vertex(UUID.randomUUID());
        graph.createEdge(vertex1, vertex2);
        assertEquals(2, graph.getSize());
        var vertex1Edges = graph.getEdges(vertex1);
        assertNotNull(vertex1Edges);
        assertEquals(1, vertex1Edges.size());
        assertEquals(vertex2, vertex1Edges.get(0));
    }
}
