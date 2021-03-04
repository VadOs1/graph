package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.AppPackage;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class GraphTest {
    private static final AppPackage PACKAGE_1 = new AppPackage("package 1");
    private static final AppPackage PACKAGE_2 = new AppPackage("package 2");
    private static final AppPackage PACKAGE_3 = new AppPackage("package 3");
    private static final AppPackage PACKAGE_4 = new AppPackage("package 4");
    private static final AppPackage PACKAGE_5 = new AppPackage("package 5");

    @Test
    public void testShouldAddPackageWithoutDependenciesToGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, null);

        // THEN
        Map<AppPackage, Set<AppPackage>> adjacencyVertices = graph.getGraph();
        assertNotNull(adjacencyVertices);
        assertEquals(1, adjacencyVertices.size());
        assertEquals(0, adjacencyVertices.get(PACKAGE_1).size());
    }

    @Test
    public void testShouldAddPackageWithDependenciesToGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));

        // THEN
        Map<AppPackage, Set<AppPackage>> adjacencyVertices = graph.getGraph();
        assertNotNull(adjacencyVertices);
        assertEquals(3, adjacencyVertices.size());
        assertEquals(2, adjacencyVertices.get(PACKAGE_1).size());
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_2));
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_3));
    }

    @Test
    public void testShouldAddTwoPackagesWithDependenciesToGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));
        graph.addPackage(PACKAGE_4, Set.of(PACKAGE_5));

        // THEN
        Map<AppPackage, Set<AppPackage>> adjacencyVertices = graph.getGraph();
        assertNotNull(adjacencyVertices);
        assertEquals(5, adjacencyVertices.size());
        assertEquals(2, adjacencyVertices.get(PACKAGE_1).size());
        assertEquals(1, adjacencyVertices.get(PACKAGE_4).size());
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_2));
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_3));
        assertTrue(adjacencyVertices.get(PACKAGE_4).contains(PACKAGE_5));
    }

    @Test
    public void testShouldAddMixedPackagesWithDependenciesToGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));
        graph.addPackage(PACKAGE_2, Set.of(PACKAGE_3));
        graph.addPackage(PACKAGE_3, Set.of(PACKAGE_4, PACKAGE_5));

        // THEN
        Map<AppPackage, Set<AppPackage>> adjacencyVertices = graph.getGraph();
        assertNotNull(adjacencyVertices);
        assertEquals(5, adjacencyVertices.size());
        assertEquals(2, adjacencyVertices.get(PACKAGE_1).size());
        assertEquals(1, adjacencyVertices.get(PACKAGE_2).size());
        assertEquals(2, adjacencyVertices.get(PACKAGE_3).size());
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_2));
        assertTrue(adjacencyVertices.get(PACKAGE_1).contains(PACKAGE_3));
        assertTrue(adjacencyVertices.get(PACKAGE_2).contains(PACKAGE_3));
        assertTrue(adjacencyVertices.get(PACKAGE_3).contains(PACKAGE_4));
        assertTrue(adjacencyVertices.get(PACKAGE_3).contains(PACKAGE_5));
    }

    @Test
    public void testShouldGetCopyOfGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();
        Map<AppPackage, Set<AppPackage>> copyOfAdjacencyVertices = graph.getGraph();
        assertEquals(0, copyOfAdjacencyVertices.size());

        // WHEN
        boolean isAdded = graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));

        // THEN
        assertTrue(isAdded);
        Map<AppPackage, Set<AppPackage>> adjacencyVertices = graph.getGraph();
        assertNotNull(adjacencyVertices);
        assertEquals(3, adjacencyVertices.size());
        assertEquals(0, copyOfAdjacencyVertices.size());
    }

    @Test
    public void testShouldRemovePackageWithoutDependenciesFromGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, null);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesBefore = graph.getGraph();
        assertEquals(1, adjacencyVerticesBefore.size());
        boolean isDeleted = graph.removePackage(PACKAGE_1);

        // THEN
        assertTrue(isDeleted);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesAfter = graph.getGraph();
        assertNotNull(adjacencyVerticesAfter);
        assertEquals(0, adjacencyVerticesAfter.size());
    }

    @Test
    public void testShouldRemovePackageWithDependenciesFromGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesBefore = graph.getGraph();
        assertEquals(3, adjacencyVerticesBefore.size());
        boolean isDeleted = graph.removePackage(PACKAGE_1);

        // THEN
        assertTrue(isDeleted);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesAfter = graph.getGraph();
        assertNotNull(adjacencyVerticesAfter);
        assertEquals(0, adjacencyVerticesAfter.size());
    }

    @Test
    public void testShouldRemoveMixedPackagesWithDependenciesFromGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2, PACKAGE_3));
        graph.addPackage(PACKAGE_4, Set.of(PACKAGE_5));
        graph.addPackage(PACKAGE_5, Set.of(PACKAGE_4));
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesBefore = graph.getGraph();
        assertEquals(5, adjacencyVerticesBefore.size());
        boolean isDeleted = graph.removePackage(PACKAGE_1);

        // THEN
        assertTrue(isDeleted);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesAfter = graph.getGraph();
        assertNotNull(adjacencyVerticesAfter);
        assertEquals(2, adjacencyVerticesAfter.size());
        assertTrue(adjacencyVerticesAfter.get(PACKAGE_4).contains(PACKAGE_5));
        assertTrue(adjacencyVerticesAfter.get(PACKAGE_5).contains(PACKAGE_4));
    }

    @Test
    public void testShouldRemoveUnusedDescendantsFromGraph() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2));
        graph.addPackage(PACKAGE_2, Set.of(PACKAGE_3, PACKAGE_4));
        graph.addPackage(PACKAGE_5, null);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesBefore = graph.getGraph();
        assertEquals(5, adjacencyVerticesBefore.size());
        boolean isDeleted = graph.removePackage(PACKAGE_1);

        // THEN
        assertTrue(isDeleted);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesAfter = graph.getGraph();
        assertNotNull(adjacencyVerticesAfter);
        assertEquals(1, adjacencyVerticesAfter.size());
        assertEquals(0, adjacencyVerticesAfter.get(PACKAGE_5).size());
    }

    @Test
    public void testShouldNotRemoveFromGraphIfReferenced() {
        // GIVEN
        Graph<AppPackage> graph = new Graph<>();

        // WHEN
        graph.addPackage(PACKAGE_1, Set.of(PACKAGE_2));
        graph.addPackage(PACKAGE_2, Set.of(PACKAGE_3, PACKAGE_4));
        graph.addPackage(PACKAGE_5, null);
        Map<AppPackage, Set<AppPackage>> adjacencyVerticesBefore = graph.getGraph();
        assertEquals(5, adjacencyVerticesBefore.size());
        boolean isDeleted = graph.removePackage(PACKAGE_2);

        // THEN
        assertFalse(isDeleted);
        assertEquals(5, adjacencyVerticesBefore.size());
    }
}
