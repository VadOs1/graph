package com.gmail.dissa.vadim.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testInitialSizeOfGraphShouldBeZero() {
        Graph graph = new Graph();
        assertEquals(0, graph.getSize());
    }

    @Test
    public void testShouldAddNullVertex() {
        Graph graph = new Graph();
        graph.addVertex(null);
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddOneVertex() {
        Graph graph = new Graph();
        graph.addVertex("name 0");
        assertEquals(1, graph.getSize());
    }

    @Test
    public void testShouldAddOneVertexAndNull() {
        Graph graph = new Graph();
        graph.addVertex(null);
        graph.addVertex("name 0");
        assertEquals(2, graph.getSize());
    }

    @Test
    public void testShouldAddNullOnlyOnce() {
        Graph graph = new Graph();
        graph.addVertex(null);
        graph.addVertex(null);
        graph.addVertex("name 0");
        assertEquals(2, graph.getSize());
    }
}
