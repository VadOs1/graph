package com.gmail.dissa.vadim.graph.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Vertex {
    private Long id;
    private String name;
}
