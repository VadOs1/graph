package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {

    @Test
    void shouldCreateEmptyGraphTest() {
        var graph = new Graph();
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenAddingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph();
            graph.addVertex(null);
        });
    }

    @Test
    void shouldThrowNullPointerExceptionWhenRemovingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph();
            assertEquals(0, graph.getSize());
            graph.removeVertex(null);
        });
    }

    @Test
    void shouldAddVertexTest() {
        var graph = new Graph();
        var vertex = new Vertex(UUID.randomUUID(), "1");
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldAddTwoVerticesTest() {
        var graph = new Graph();
        var vertex1 = new Vertex(UUID.randomUUID(), "1");
        var vertex2 = new Vertex(UUID.randomUUID(), "1");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    void shouldAddThreeVerticesTest() {
        var graph = new Graph();
        var vertex1 = new Vertex(UUID.randomUUID(), "1");
        var vertex2 = new Vertex(UUID.randomUUID(), "1");
        var vertex3 = new Vertex(null, null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
    }

    @Test
    void shouldCreateGraphFromVertexBoardMatrixTest() {
        // GIVEN
        Vertex[][] matrix = new Vertex[3][6];
        matrix[0][0] = new Vertex(UUID.randomUUID(), "1");
        matrix[0][1] = new Vertex(UUID.randomUUID(), "1");
        matrix[0][2] = new Vertex(UUID.randomUUID(), "1");
        matrix[0][3] = new Vertex(UUID.randomUUID(), "1");
        matrix[0][4] = new Vertex(UUID.randomUUID(), "1");
        matrix[0][5] = new Vertex(UUID.randomUUID(), "1");

        matrix[1][0] = new Vertex(UUID.randomUUID(), "1");
        matrix[1][1] = new Vertex(UUID.randomUUID(), "1");
        matrix[1][2] = new Vertex(UUID.randomUUID(), "1");
        matrix[1][3] = new Vertex(UUID.randomUUID(), "1");
        matrix[1][4] = new Vertex(UUID.randomUUID(), "1");
        matrix[1][5] = new Vertex(UUID.randomUUID(), "1");

        matrix[2][0] = new Vertex(UUID.randomUUID(), "1");
        matrix[2][1] = new Vertex(UUID.randomUUID(), "1");
        matrix[2][2] = new Vertex(UUID.randomUUID(), "1");
        matrix[2][3] = new Vertex(UUID.randomUUID(), "1");
        matrix[2][4] = new Vertex(UUID.randomUUID(), "1");
        matrix[2][5] = new Vertex(UUID.randomUUID(), "1");

        // WHEN
        var graph = new Graph(matrix);

        // THEN
        assertEquals(18, graph.getSize());
    }

    @Test
    void shouldAddVertexWithNullsOnlyOnceTest() {
        var graph = new Graph();
        var vertex1 = new Vertex(null, null);
        var vertex2 = new Vertex(null, null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldDeleteNothingFromEmptyGraphTest() {
        var graph = new Graph();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(UUID.randomUUID(), ""));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldDeleteFromGraphTest() {
        var graph = new Graph();
        var vertex1 = new Vertex(UUID.randomUUID(), "1");
        var vertex2 = new Vertex(null, "1");
        var vertex3 = new Vertex(UUID.randomUUID(), null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
        graph.removeVertex(vertex3);
        assertEquals(2, graph.getSize());
    }

    @Test
    void shouldDeleteNothingFromEmptyGraphWithNullsTest() {
        var graph = new Graph();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(null, null));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldCreateAndReturnEdgesTest() {
        var graph = new Graph();
        var vertex1 = new Vertex(UUID.randomUUID(), "1");
        var vertex2 = new Vertex(UUID.randomUUID(), "2");
        graph.createEdge(vertex1, vertex2);
        assertEquals(2, graph.getSize());
        var vertex1Edges = graph.getEdges(vertex1);
        assertNotNull(vertex1Edges);
        assertEquals(1, vertex1Edges.size());
        assertEquals(vertex2, vertex1Edges.get(0));
    }
}
