package com.java11.samples.algorithms.graph;

import java.util.LinkedList;
import java.util.List;

public class BredthFirstSearch {

    private class Graph {

        List<Integer>[] vertexArray;
        boolean[] visited;

        public Graph(int vertex) {
            vertexArray = new LinkedList[vertex];
            visited = new boolean[vertex];
            for(int i = 0; i < vertex; i++) {
                vertexArray[i] = new LinkedList<>();
            }
        }

        public void addEdge(int vertex, int edge) {
            vertexArray[vertex].add(edge);
        }

        public void BFS(int vertex) {
            LinkedList<Integer> queue = new LinkedList<Integer>();

            visited[vertex] = true;
            queue.add(vertex);

            while (queue.size() > 0) {
                int index = queue.poll();
                System.out.println(index);
                List<Integer> list = vertexArray[index];
                if (list.size() > 0) {
                    for(int i : list) {
                        if (!visited[i]) {
                            visited[i] = true;
                            queue.add(i);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new BredthFirstSearch().new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
    }

}
