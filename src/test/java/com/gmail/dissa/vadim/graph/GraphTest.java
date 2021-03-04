package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.Set;
import java.util.UUID;

import static org.junit.Assert.*;

public class GraphTest {
    private static final String ID = "c1a92418-0620-4462-837e-4041c01395ea";

//    @Test
//    public void testInitialSizeOfGraphShouldBeZero() {
//        Graph<Vertex> graph = new Graph<>();
//        assertEquals(0, graph.getVertexCount());
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testShouldThrowNullPointerExceptionWhenAddingNullVertex() {
//        Graph<Vertex> graph = new Graph<>();
//        graph.addVertex(null);
//    }
//
//    @Test
//    public void testShouldAddVertexWithIdNull() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex = new Vertex(null);
//        graph.addVertex(vertex);
//        assertEquals(1, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldAddVertexWithIdNullOnlyOnce() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(null);
//        Vertex vertex2 = new Vertex(null);
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        assertEquals(1, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldAddVertex() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex);
//        assertEquals(1, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldAddTwoVertices() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        assertEquals(2, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldAddThreeVertices() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        Vertex vertex3 = new Vertex(null);
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.addVertex(vertex3);
//        assertEquals(3, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldCreateAndReturnEdges() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.createEdge(vertex1, vertex2);
//        assertEquals(2, graph.getVertexCount());
//        Set<Vertex> vertex1Edges = graph.getEdges(vertex1);
//        assertNotNull(vertex1Edges);
//        assertEquals(1, vertex1Edges.size());
//        assertTrue(vertex1Edges.contains(vertex2));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testShouldThrowExceptionWhenNoToVertexExistInGraph() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.createEdge(vertex1, vertex2);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testShouldThrowExceptionWhenNoVertexFromExistInGraph() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex2);
//        graph.createEdge(vertex1, vertex2);
//    }
//
//    @Test
//    public void testShouldRemoveVertexWithUsageCheck() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        Vertex vertex3 = new Vertex(UUID.randomUUID());
//        Vertex vertex4 = new Vertex(UUID.randomUUID());
//        Vertex vertex5 = new Vertex(UUID.randomUUID());
//        Vertex vertex6 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.addVertex(vertex3);
//        graph.addVertex(vertex4);
//        graph.addVertex(vertex5);
//        graph.addVertex(vertex6);
//        graph.createEdge(vertex1, vertex2);
//        graph.createEdge(vertex2, vertex3);
//        graph.createEdge(vertex3, vertex4);
//        graph.createEdge(vertex4, vertex5);
//        boolean isRemoved = graph.removePackage(vertex1);
//        assertTrue(isRemoved);
//        assertEquals(1, graph.getVertexCount());
//    }
//
//    @Test
//    public void testShouldNotRemoveVertexWithUsageCheck() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.createEdge(vertex1, vertex2);
//        boolean isRemoved = graph.removePackage(vertex2);
//        assertFalse(isRemoved);
//    }
//
//    @Test
//    public void testShouldKeepEdgesWhenTheSameVertexAddedMultipleTimes() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.createEdge(vertex1, vertex2);
//        assertEquals(1, graph.getEdges(vertex1).size());
//        graph.addVertex(vertex1);
//        assertEquals(1, graph.getEdges(vertex1).size());
//    }
//
//    @Test
//    public void testShouldNotCreateMultipleEdgesForTheSameVertex() {
//        Graph<Vertex> graph = new Graph<>();
//        Vertex vertex1 = new Vertex(UUID.randomUUID());
//        Vertex vertex2 = new Vertex(UUID.randomUUID());
//        graph.addVertex(vertex1);
//        graph.addVertex(vertex2);
//        graph.createEdge(vertex1, vertex2);
//        graph.createEdge(vertex1, vertex2);
//        assertEquals(1, graph.getEdges(vertex1).size());
//    }
}
