package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import com.gmail.dissa.vadim.graph.model.VertexBoard;
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
    void shouldCreateGraphFromMatrixTest() {
        // GIVEN
        var vertex1 = new Vertex(1L);
        var vertex2 = new Vertex(2L);
        var vertex3 = new Vertex(3L);
        var vertex4 = new Vertex(4L);
        Vertex[][] matrix = new Vertex[2][2];
        matrix[0][0] = vertex1;
        matrix[0][1] = vertex2;
        matrix[1][0] = vertex3;
        matrix[1][1] = vertex4;

        // WHEN
        var graph = new Graph<>(matrix);

        // THEN
        assertEquals(4, graph.getSize());
    }

    @Test
    void shouldCreateGraphFromVertexBoardMatrixTest() {
        // GIVEN
        VertexBoard[][] matrix = new VertexBoard[3][6];
        matrix[0][0] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[0][1] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[0][2] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[0][3] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[0][4] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[0][5] = new VertexBoard(UUID.randomUUID(), "1");

        matrix[1][0] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[1][1] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[1][2] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[1][3] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[1][4] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[1][5] = new VertexBoard(UUID.randomUUID(), "1");

        matrix[2][0] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[2][1] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[2][2] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[2][3] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[2][4] = new VertexBoard(UUID.randomUUID(), "1");
        matrix[2][5] = new VertexBoard(UUID.randomUUID(), "1");

        // WHEN
        var graph = new Graph<>(matrix);

        // THEN
        assertEquals(18, graph.getSize());
    }

    @Test
    void shouldThrowNullPointerExceptionWhenAddingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<Vertex>();
            graph.addVertex(null);
        });
    }

    @Test
    void shouldThrowNullPointerExceptionWhenRemovingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<Vertex>();
            assertEquals(0, graph.getSize());
            graph.removeVertex(null);
        });
    }

    @Test
    void shouldAddVertexTest() {
        var graph = new Graph<Vertex>();
        var vertex = new Vertex(0L);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldAddTwoVerticesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    void shouldAddThreeVerticesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        var vertex3 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
    }

    @Test
    void shouldAddVertexWithIdNullOnlyOnceTest() {
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
        graph.removeVertex(new Vertex(0L));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldDeleteFromGraphTest() {
        var graph = new Graph<Vertex>();
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
    void shouldDeleteNothingFromEmptyGraphWithIdNullTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(null));
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldDeleteFromGraphWithIdNullTest() {
        var graph = new Graph<Vertex>();
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
    void shouldCreateAndReturnEdgesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        graph.createEdge(vertex1, vertex2);
        assertEquals(2, graph.getSize());
        var vertex1Edges = graph.getEdges(vertex1);
        assertNotNull(vertex1Edges);
        assertEquals(1, vertex1Edges.size());
        assertEquals(vertex2, vertex1Edges.get(0));
    }

    @Test
    void shouldPrintGraphTest() {
        assertDoesNotThrow(() -> {
            var graph = new Graph<Vertex>();
            var vertex1 = new Vertex(0L);
            var vertex2 = new Vertex(1L);
            graph.createEdge(vertex1, vertex2);
            graph.print();
        });
    }
}
