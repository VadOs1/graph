package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphDijkstraTest {
    @Test
    void shouldAddVertexTest() {
        var graph = new GraphDijkstra<Node>();
        var vertex = new Node(1, 9);
        graph.addVertex(vertex);
        assertEquals(1, graph.getSize());
    }
}
