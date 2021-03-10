package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.AppCell;
import com.gmail.dissa.vadim.graph.model.Vertex;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
                {'1', '1', '1', '1'},
                {'1', 'X', 'X', '1'},
                {'1', 'X', 'X', '1'},
                {'O', '1', '1', '1'}
        };
        AppCell source = new AppCell('1', 0, 0);
        AppCell target = null;
        Map<Coordinate, Character> coordinatesCharacterMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i].length; k++) {
                coordinatesCharacterMap.put(new Coordinate(i, k), chars[i][k]);
                if (chars[i][k] == 'O') {
                    target = new AppCell(chars[i][k], k, i);
                }
            }
        }

        GraphDijkstraPriorityQueue<AppCell> graph = new GraphDijkstraPriorityQueue<>();
        for (Map.Entry<Coordinate, Character> entry : coordinatesCharacterMap.entrySet()) {
            Coordinate currentCoordinate = entry.getKey();
            Character currentCharacterValue = entry.getValue();
            addEdges(currentCoordinate.x, currentCoordinate.y, currentCharacterValue, coordinatesCharacterMap, graph);
        }
        double pathCost = graph.findShortestPathCost(source, target);
        assertEquals(3.0, pathCost, 0);
    }

    private void addEdges(int currentCoordinateX, int currentCoordinateY, char currentValue, Map<Coordinate, Character> map, GraphDijkstraPriorityQueue<AppCell> graph) {
        AppCell cell = new AppCell(currentValue, currentCoordinateX, currentCoordinateY);
        graph.addVertex(cell);
        if (currentValue == 'X') {
            // no connections
        } else {
            Coordinate leftCoordinate = new Coordinate(currentCoordinateY, currentCoordinateX - 1);
            addEdge(cell, leftCoordinate, map.get(leftCoordinate), graph);

            Coordinate rightCoordinate = new Coordinate(currentCoordinateY, currentCoordinateX + 1);
            addEdge(cell, rightCoordinate, map.get(rightCoordinate), graph);

            Coordinate topCoordinate = new Coordinate(currentCoordinateY - 1, currentCoordinateX);
            addEdge(cell, topCoordinate, map.get(topCoordinate), graph);

            Coordinate bottomCoordinate = new Coordinate(currentCoordinateY + 1, currentCoordinateX);
            addEdge(cell, bottomCoordinate, map.get(bottomCoordinate), graph);
        }
    }

    private void addEdge(AppCell appCell, Coordinate coordinate, Character character, GraphDijkstraPriorityQueue<AppCell> graph) {
        if (character == null) {
            return;
        }
        if (character != 'X') {
            graph.createVerticesAndEdge(appCell, new AppCell(character, coordinate.x, coordinate.y), 1.0);
        }
    }


    class Coordinate {
        public int y;
        public int x;

        public Coordinate(int y, int x) {
            this.y = y;
            this.x = x;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
