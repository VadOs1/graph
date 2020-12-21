package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.VertexPackage;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class GraphPackage extends Graph<VertexPackage> {

    public void addVertexAndDependencies(VertexPackage vertex, List<VertexPackage> dependencies) {
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

    public void removeVertexWithDependenciesCheck(VertexPackage vertex) {
        if (vertex == null) {
            throw new IllegalArgumentException("Can not remove null vertex");
        }

        if (adjacencyVertexes.values().stream().flatMap(Collection::stream).anyMatch(vertex::equals)) {
            throw new IllegalArgumentException("Cannot remove vertex. There is dependency on it");
        }
        var dependencies = getEdges(vertex);
        removeVertex(vertex);
        if(dependencies != null){
            removeUnusedDependencies(dependencies);
        }
    }

    private void removeUnusedDependencies(Set<VertexPackage> dependencies){
        dependencies.forEach(dependency -> {
            if (adjacencyVertexes.values().stream().flatMap(Collection::stream).noneMatch(dependencies::equals)) {
                removeVertexWithDependenciesCheck(dependency);
            }
        });
    }
}
