

import BinaryTree.TreeNode;
import Graph.easy.DisjointSet;
import HashTables.HashTable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Practice {
    static class Pair{
        int toNode, weight;
        Pair(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }
    }


    public static ArrayList<ArrayList<Pair>> edgesToList_Directed_Weighted(int[][] edges, int n) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
//        System.out.println(graph);
        return graph;
    }


    public static void shortestDist_DAG_Weighted(ArrayList<ArrayList<Pair>> graph, int n, int[] dist, int src) {
//      No vis arr required, As multiple visits can be done to a node, and then we see whose dist is min!!
        Queue<Integer> q = new ArrayDeque<>();
//      Replace each val with (infinity) and then replace it if a dist lower than that occurs.
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int parent = q.remove();

            for (Pair adjNode : graph.get(parent)) {
//              Check if the dist to adjNode from src is less than its stored Dist, then replace. Else ignore
//              dist[parent] is dist of parent from src
                int newDist = dist[parent] + adjNode.weight;

                if (newDist < dist[adjNode.toNode]){
                    dist[adjNode.toNode] = newDist;
//                  only that adjNode must enter queue, whose new dist </<= its current dist.
//                  REASON in copy. why its inside if.
                    q.add(adjNode.toNode);
                }
//              else ignore newDist.
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
    }

}


