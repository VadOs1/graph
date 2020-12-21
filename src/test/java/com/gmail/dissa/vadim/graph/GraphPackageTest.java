package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.VertexPackage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
