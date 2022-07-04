package com.java11.samples.algorithms.graph.dijkstra;

import java.net.FileNameMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DikstraAlgorithm {

    // I know Integer.MAX_VALUE is not infinity, but I feel comfortable using this variable name in certain scenario.
    private static final int INFINITY = Integer.MAX_VALUE;

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        var numberOfEdges = edges.length;

        int[] minDistances = new int[numberOfEdges];
        Arrays.fill(minDistances,  INFINITY);
        minDistances[start] = 0;
        Set<Integer> visited = new HashSet<>();

        while(visited.size() < numberOfEdges) {
            var getShortestVertex = getShortestVertex(minDistances, visited);
            var minDistance = getShortestVertex[0];
            var vertex = getShortestVertex[1];
            visited.add(vertex);

            for(int [] arr : edges[vertex]) {
                if(visited.contains(arr[0])) continue;
                int calculatedDistance = arr[1] + minDistance;
                if(calculatedDistance < minDistances[arr[0]]) {
                    minDistances[arr[0]] = calculatedDistance;
                }
            }
        }
        return minDistances;
    }

    private int[] getShortestVertex(int[] minDistances, Set<Integer> visited) {
        int min = INFINITY;
        int vertex = -1;
        for(int i = 0; i < minDistances.length ; i++) {
            if(minDistances[i] <= min && !visited.contains(i)) {
                min = minDistances[i];
                vertex = i;
            }
        }
        return new int[] {min, vertex};
    }

    public static void main(String[] args) {
        DikstraAlgorithm dikstraAlgorithm = new DikstraAlgorithm();
        int[][][] edges = {
                {
                        {1, 7}
                },
                {
                        {2, 6},
                        {3, 20},
                        {4, 3}
                },
                {
                        {3, 14}
                },
                {
                        {4, 2}
                },
                {},
                {}
        };
        int[] minDistances = dikstraAlgorithm.dijkstrasAlgorithm(0, edges);
        Arrays.stream(minDistances).forEach(k -> System.out.println(k));
    }

}
