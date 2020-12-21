package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.VertexPackage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraphPackageTest {

    @Test
    void shouldCreateEmptyGraphTest() {
        var graph = new GraphPackage();
        assertEquals(0, graph.getSize());
    }

    @Test
    void shouldAddVertexTest() {
        var graph = new GraphPackage();
        var vertex = new VertexPackage("package name");
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }

    @Test
    void shouldAddVertexAndDependencies() {
        var vertexPackage1 = new VertexPackage("pkg1");
        var vertexPackage2 = new VertexPackage("pkg2");
        var vertexPackage3 = new VertexPackage("pkg3");
        var graph = new GraphPackage();
        graph.addVertexAndDependencies(vertexPackage1, Collections.singletonList(vertexPackage2));
        graph.addVertexAndDependencies(vertexPackage1, Arrays.asList(vertexPackage2, vertexPackage3));
        graph.addVertexAndDependencies(vertexPackage2, Collections.singletonList(vertexPackage3));

        assertEquals(3, graph.getSize());
        assertEquals(2, graph.getEdges(vertexPackage1).size());
        assertEquals(1, graph.getEdges(vertexPackage2).size());
        assertEquals(0, graph.getEdges(vertexPackage3).size());
    }

    @Test
    void shouldNotDeletePackageIfThereIsDependencyOnItTest() {
        var vertexPackage1 = new VertexPackage("pkg1");
        var vertexPackage2 = new VertexPackage("pkg2");
        var vertexPackage3 = new VertexPackage("pkg3");
        var graph = new GraphPackage();
        graph.addVertexAndDependencies(vertexPackage1, Collections.singletonList(vertexPackage2));
        graph.addVertexAndDependencies(vertexPackage1, Arrays.asList(vertexPackage2, vertexPackage3));
        graph.addVertexAndDependencies(vertexPackage2, Collections.singletonList(vertexPackage3));

        assertThrows(IllegalArgumentException.class, () -> graph.removeVertex(vertexPackage2));
    }
}
