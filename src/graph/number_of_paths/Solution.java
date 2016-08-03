package graph.number_of_paths;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ugurdonmez on 31/07/16.
 */

/*

 google-interview-questions

Given a graph and a source node and destination node,
find the number of shortest paths present between source and destination.

Hint: Use BFS

 */
public class Solution {


    public static int getNumberOfPaths(int [][] adjMatrix, int source, int destination) {

        PriorityQueue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(0, source, 1));

        boolean [] founds = new boolean[adjMatrix.length];
        int [] ways = new int[adjMatrix.length];
        int [] minCosts = new int[adjMatrix.length];

        for (int i = 0; i < adjMatrix.length; i++) {
            minCosts[i] = Integer.MAX_VALUE;
        }

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (founds[n.vertex] == false) {
                ways[n.vertex] += n.way;
                founds[n.vertex] = true;
                break;
            }

            if (founds[n.vertex] && minCosts[n.vertex] == n.cost) {
                ways[n.vertex] += n.way;
                continue;
            }

            if (founds[n.vertex] && minCosts[n.vertex] > n.cost) {
                ways[n.vertex] = n.way;
                minCosts[n.vertex]= n.cost;

                for (int i = 0; i < adjMatrix.length; i++) {
                    if (adjMatrix[n.vertex][i] != 0) {
                        if (founds[i] == false) {
                            queue.add(new Node(n.cost + adjMatrix[n.vertex][i], i, n.way));
                        }
                    }
                }

                continue;
            }

            for (int i = 0; i < adjMatrix.length; i++) {
                if (adjMatrix[n.vertex][i] != 0) {
                    if (founds[i] == false) {
                        queue.add(new Node(n.cost + adjMatrix[n.vertex][i], i, n.way));
                    }
                }
            }
        }

        return ways[destination];
    }

}

class Node implements Comparable<Node>{
    final int cost;
    final int vertex;
    final int way;

    public Node(int cost, int vertex, int way) {
        this.cost = cost;
        this.vertex = vertex;
        this.way = way;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }
}
