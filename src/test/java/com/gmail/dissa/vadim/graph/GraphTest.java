package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GraphTest {

    @Test
    public void shouldCreateEmptyGraphTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
    }

    @Test
    public void shouldCreateGraphFromMatrixTest() {
        // GIVEN
        var vertex1 = new Vertex(1l);
        var vertex2 = new Vertex(2l);
        var vertex3 = new Vertex(3l);
        var vertex4 = new Vertex(4l);
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
    public void shouldThrowNullPointerExceptionWhenAddingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<Vertex>();
            graph.addVertex(null);
        });
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenRemovingNullVertexTest() {
        assertThrows(NullPointerException.class, () -> {
            var graph = new Graph<Vertex>();
            assertEquals(0, graph.getSize());
            graph.removeVertex(null);
        });
    }

    @Test
    public void shouldAddVertexTest() {
        var graph = new Graph<Vertex>();
        var vertex = new Vertex(0L);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void shouldAddTwoVerticesTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(0L);
        var vertex2 = new Vertex(1L);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    public void shouldAddThreeVerticesTest() {
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
    public void shouldAddVertexWithIdNullOnlyOnceTest() {
        var graph = new Graph<Vertex>();
        var vertex1 = new Vertex(null);
        var vertex2 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void shouldDeleteNothingFromEmptyGraphTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(0L));
        assertEquals(0, graph.getSize());
    }

    @Test
    public void shouldDeleteFromGraphTest() {
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
    public void shouldDeleteNothingFromEmptyGraphWithIdNullTest() {
        var graph = new Graph<Vertex>();
        assertEquals(0, graph.getSize());
        graph.removeVertex(new Vertex(null));
        assertEquals(0, graph.getSize());
    }

    @Test
    public void shouldDeleteFromGraphWithIdNullTest() {
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
    public void shouldCreateAndReturnEdgesTest() {
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
}
