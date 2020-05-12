package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testInitialSizeOfGraphShouldBeZero() {
        Graph<Vertex> graph = new Graph<>();
        assertEquals(0, graph.getSize());
    }

    @Test
    public void testShouldAddVertexWithIdNull() {
        Graph<Vertex> graph = new Graph<>();
        Vertex vertex = new Vertex(null);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddVertexWithIdNullOnlyOnce() {
        Graph<Vertex> graph = new Graph<>();
        Vertex vertex1 = new Vertex(null);
        Vertex vertex2 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddVertex() {
        Graph<Vertex> graph = new Graph<>();
        Vertex vertex = new Vertex(0L);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddTwoVertices() {
        Graph<Vertex> graph = new Graph<>();
        Vertex vertex1 = new Vertex(0L);
        Vertex vertex2 = new Vertex(1L);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        assertEquals(2, graph.getSize());
    }

    @Test
    public void testShouldAddThreeVertices() {
        Graph<Vertex> graph = new Graph<>();
        Vertex vertex1 = new Vertex(0L);
        Vertex vertex2 = new Vertex(1L);
        Vertex vertex3 = new Vertex(null);
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        assertEquals(3, graph.getSize());
    }
}
