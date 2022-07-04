package com.java11.samples.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    private class Graph {
        private List<Integer> vertexArray[];
        private boolean[] visited;

        public Graph(int nodes) {
            vertexArray = new LinkedList[nodes];
            visited = new boolean[nodes];

            for(int i = 0; i < vertexArray.length; i++) {
                vertexArray[i] = new LinkedList<Integer>();
            }

            for(int i = 0; i < vertexArray.length; i++) {
                System.out.print(vertexArray[i].size() + " ");
            }
            System.out.println();
        }

        private void addEdge(int vertex, int edge) {
            vertexArray[vertex].add(edge);
        }

        public void DFS2(int vertex) {
            System.out.println(vertex);
            visited[vertex] = true;
            if (vertexArray[vertex].size() > 0) {
                for(int i : vertexArray[vertex]) {
                    if (!visited[i]) {
                        DFS2(i);
                    }
                }
            }
        }

        void DFS(int vertex) {
            visited[vertex] = true;
            System.out.print(vertex + " ");

            Iterator<Integer> ite = vertexArray[vertex].listIterator();
            while (ite.hasNext()) {
                int adj = ite.next();
                if (!visited[adj])
                    DFS(adj);
            }
        }

        void checkUnmarked() {
            for(int i = 0; i < vertexArray.length; i++) {
                if (!visited[i]) {
                    DFS(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch();
        DepthFirstSearch.Graph graph = dfs.new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);
        graph.DFS(3);
        graph.checkUnmarked();
    }

}


