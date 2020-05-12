package com.gmail.dissa.vadim.graph;

import com.gmail.dissa.vadim.graph.model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Graph {
    private AtomicLong id;
    private Map<Vertex, List<Vertex>> adjacencyVertexes;

    public Graph() {
        id = new AtomicLong(-1);
        adjacencyVertexes = new ConcurrentHashMap<>();
    }

    public int getSize(){
        return adjacencyVertexes.size();
    }

    public void addVertex(String name) {
        long vertexId = id.addAndGet(1);
        Vertex vertex = new Vertex(vertexId, name);
        adjacencyVertexes.putIfAbsent(vertex, new ArrayList<>());
    }

    public void removeVertex(String name) {
        adjacencyVertexes.keySet().removeIf(vertex -> {
                    if (name == null) {
                        return vertex.getName() == null;
                    } else {
                        return vertex.getName().equals(name);
                    }
                }
        );
    }
}
