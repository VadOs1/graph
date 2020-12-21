package com.gmail.dissa.vadim.graph;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class GraphPackage<T> extends Graph<T> {

    public void addVertexAndDependencies(T vertex, List<T> dependencies) {
        if (vertex == null || dependencies == null) {
            throw new IllegalArgumentException("Vertex and dependencies should not be nulls");
        }
        dependencies.forEach(dependency -> {
            if (dependency != null && !dependency.equals(vertex)) {
                createEdge(vertex, dependency);
            }
        });
        print();
    }

    public void removeVertexWithDependenciesCheck(T vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Can not remove null vertex");
        }

        if (adjacencyVertexes.values().stream().flatMap(Collection::stream).anyMatch(vertex::equals)) {
            throw new IllegalArgumentException("Cannot remove vertex. There is dependency on it");
        }
        var dependencies = getEdges(vertex);
        removeVertex(vertex);
        if (dependencies != null) {
            removeUnusedDependencies(dependencies);
        }
    }

    private void removeUnusedDependencies(Set<T> dependencies) {
        dependencies.forEach(dependency -> {
            if (adjacencyVertexes.values().stream().flatMap(Collection::stream).noneMatch(dependency::equals)) {
                removeVertexWithDependenciesCheck(dependency);
            }
        });
    }
}
