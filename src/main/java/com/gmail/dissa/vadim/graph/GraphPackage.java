package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.VertexPackage;

import java.util.List;

public class GraphPackage extends Graph<VertexPackage> {

    public void addVertexAndDependencies(VertexPackage vertex, List<VertexPackage> dependencies) {
        if (vertex == null || dependencies == null) {
            throw new IllegalArgumentException("Vertex and dependencies should not be nulls");
        }
        dependencies.forEach(dependency -> {
            if(dependency != null && !dependency.equals(vertex)){
                createEdge(vertex, dependency);
            }
        });
        print();
    }
}
