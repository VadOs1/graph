package com.gmail.dissa.vadim.graph.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VertexBoard {
    private UUID id;
    private String value;
}
