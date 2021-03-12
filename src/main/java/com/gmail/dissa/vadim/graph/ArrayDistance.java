package com.gmail.dissa.vadim.graph;

import java.util.LinkedList;
import java.util.Queue;

class Q {
    int row;
    int col;
    int dist;

    public Q(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class ArrayDistance {
    private static final char SOURCE_CHAR = 'O';
    private static final char TARGET_CHAR = 'I';
    private static final char STOP_CHAR = 'X';

    private static int findMinDistance(char[][] grid) {
        Q source = getSource(grid);
        Queue<Q> queue = new LinkedList<>();
        queue.add(source);
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[source.row][source.col] = true;

        while (!queue.isEmpty()) {
            Q q = queue.remove();

            if (grid[q.row][q.col] == TARGET_CHAR) {
                return q.dist;
            }

            // up
            if (isValid(q.row - 1, q.col, grid, visited)) {
                queue.add(new Q(q.row - 1, q.col, q.dist + 1));
                visited[q.row - 1][q.col] = true;
            }

            // down
            if (isValid(q.row + 1, q.col, grid, visited)) {
                queue.add(new Q(q.row + 1, q.col, q.dist + 1));
                visited[q.row + 1][q.col] = true;
            }

            // left
            if (isValid(q.row, q.col - 1, grid, visited)) {
                queue.add(new Q(q.row, q.col - 1, q.dist + 1));
                visited[q.row][q.col - 1] = true;
            }

            // right
            if (isValid(q.row, q.col + 1, grid, visited)) {
                queue.add(new Q(q.row, q.col + 1, q.dist + 1));
                visited[q.row][q.col + 1] = true;
            }
        }
        return -1;
    }

    private static Q getSource(char[][] grid){
        Q source = new Q(0, 0, 0);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == SOURCE_CHAR) {
                    source.row = i;
                    source.col = j;
                    source.dist = 0;
                    break;
                }
            }
        }
        return source;
    }

    private static boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        return row >= 0 && col >= 0 &&
                row < grid.length && col < grid[0].length &&
                grid[row][col] != STOP_CHAR &&
                !visited[row][col];
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'O', '1', 'X', 'I'},
                {'1', '1', 'X', '1'},
                {'1', '1', 'X', '1'},
                {'1', '1', '1', '1'}
        };
        System.out.println(findMinDistance(grid));
    }
}
