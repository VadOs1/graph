package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.AppCell;
import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;


public class GraphDijkstraPriorityQueueTest {

    @Test
    public void testShouldRemoveVertexAndReturnCorrectVertexCount() {
        var graphDijkstra = new GraphDijkstraPriorityQueue<>();
        assertEquals(0, graphDijkstra.getVertexCount());
        var v1 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        graphDijkstra.removeVertex(v1);
        assertEquals(0, graphDijkstra.getVertexCount());
    }

    @Test
    public void textShouldAddVertexAndReturnCorrectVertexCount() {
        var graphDijkstra = new GraphDijkstraPriorityQueue<>();
        assertEquals(0, graphDijkstra.getVertexCount());
        var v1 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        graphDijkstra.addVertex(v1);
        assertEquals(1, graphDijkstra.getVertexCount());
        var v2 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v2);
        assertEquals(2, graphDijkstra.getVertexCount());

    }

    @Test
    public void testShouldCreateAndGetEdges() {
        var graphDijkstra = new GraphDijkstraPriorityQueue<>();
        var v1 = new Vertex(UUID.randomUUID());
        var v2 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        graphDijkstra.addVertex(v2);
        graphDijkstra.createEdge(v1, v2, 1.0);
        graphDijkstra.createEdge(v1, v2, 2.0);
        assertEquals(2, graphDijkstra.getVertexCount());
        var v1Edges = graphDijkstra.getEdges(v1);
        assertEquals(1, v1Edges.size());
        assertEquals(2.0, v1Edges.get(v2), 0);
    }


    @Test
    public void testShouldFindShortestPathCost() {
        // GIVEN
        var graphDijkstra = new GraphDijkstraPriorityQueue<>();

        // WHEN
        var v1 = new Vertex(UUID.randomUUID());
        var v2 = new Vertex(UUID.randomUUID());
        var v3 = new Vertex(UUID.randomUUID());
        var v4 = new Vertex(UUID.randomUUID());
        var v5 = new Vertex(UUID.randomUUID());
        var v6 = new Vertex(UUID.randomUUID());
        var v7 = new Vertex(UUID.randomUUID());
        var v8 = new Vertex(UUID.randomUUID());
        var v9 = new Vertex(UUID.randomUUID());
        var v10 = new Vertex(UUID.randomUUID());
        graphDijkstra.addVertex(v1);
        graphDijkstra.addVertex(v2);
        graphDijkstra.addVertex(v3);
        graphDijkstra.addVertex(v4);
        graphDijkstra.addVertex(v5);
        graphDijkstra.addVertex(v6);
        graphDijkstra.addVertex(v7);
        graphDijkstra.addVertex(v8);
        graphDijkstra.addVertex(v9);
        graphDijkstra.addVertex(v10);
        graphDijkstra.createEdge(v1, v2, 1.0);
        graphDijkstra.createEdge(v2, v3, 1.0);
        graphDijkstra.createEdge(v3, v4, 1.0);
        graphDijkstra.createEdge(v1, v5, 1.0);
        graphDijkstra.createEdge(v5, v6, 1.0);
        graphDijkstra.createEdge(v5, v7, 1.0);
        graphDijkstra.createEdge(v7, v8, 1.0);
        graphDijkstra.createEdge(v8, v9, 1.0);
        graphDijkstra.createEdge(v9, v8, 1.0);

        // THEN
        var distanceCost = graphDijkstra.findShortestPathCost(v1, v9);
        assertEquals(4.0, distanceCost, 0);
    }

    @Test
    public void testMatrix() {
        char[][] chars = new char[][]{
                {'I', '1', '1', '1'},
                {'X', '1', '1', '1'},
                {'X', '1', '1', '1'},
                {'O', '1', '1', '1'}
        };

        char SOURCE_CHAR = 'I';
        char TARGET_CHAR = 'O';
        char STOP_CHAR = 'X';

        GraphDijkstraPriorityQueue<AppCell> graph = new GraphDijkstraPriorityQueue<>();
        AppCell source = null;
        AppCell target = null;

        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                AppCell currentCell = new AppCell(chars[i][k], i, k);
                graph.addVertex(currentCell);

                if (currentCell.getC() != STOP_CHAR) {
                    if (k - 1 >= 0) {   // left
                        addEdge(currentCell, chars[i][k - 1], i, k - 1, 1.0, STOP_CHAR, graph);
                    }
                    if (k + 1 < chars[i].length) {  // right
                        addEdge(currentCell, chars[i][k + 1], i, k + 1, 1.0, STOP_CHAR, graph);
                    }
                    if (i - 1 >= 0) { // top
                        addEdge(currentCell, chars[i - 1][k], i - 1, k, 1.0, STOP_CHAR, graph);
                    }
                    if (i + 1 < chars.length) { // bottom
                        addEdge(currentCell, chars[i + 1][k], i + 1, k, 1.0, STOP_CHAR, graph);
                    }
                    if (chars[i][k] == SOURCE_CHAR) { // source
                        source = new AppCell(chars[i][k], i, k);
                    }

                    if (chars[i][k] == TARGET_CHAR) { // target
                        target = new AppCell(chars[i][k], i, k);
                    }
                }
            }
        }
        assertEquals(5.0, graph.findShortestPathCost(source, target), 0);
    }

    private void addEdge(AppCell appCell, char c, int y, int x, double cost, char stopChar, GraphDijkstraPriorityQueue<AppCell> graph) {
        if (c != stopChar) {
            graph.createVerticesAndEdge(appCell, new AppCell(c, y, x), cost);
        }
    }
}
