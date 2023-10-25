package Graph.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ChaepestFlightKStopsDONE {
    class Solution {
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            // create a graph using adjacency list  of Pair type.
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                adj.add(new ArrayList<Pair>());
            }
            // add the destination and the price(weight of edge).
            for(int i = 0 ; i < flights.length ; i++){
                adj.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
            }
            // create a distance array and fill it with infinity.
            int[] dist = new int[n];
            Arrays.fill(dist , Integer.MAX_VALUE);
            // create a queue of tuple type and add source , price = 0 , stops = 0

        /*
        why we are not using PriorityQueue here ????
        because we are removing nodes from queue based on their stops and the stops
		increments by 1, so we eventually get sorted by stops in queue and queue
        by-default removes elements from front, so we will get the minimum stop node
        that's why we are not using the priorityqueue
        here we can also not that using PQ may exceed the number of stops required
        */
            Queue<Tuple> que = new LinkedList<>();
            que.add(new Tuple(src , 0 , 0));
            while(!que.isEmpty()){
                Tuple curr = que.poll();
                // tka cost and stops of current node.
                int cost = curr.wt;
                int stops = curr.st;
                // if stops are greater than k then skip the path
                if(stops > k){
                    continue;
                }
                // go for the neighbours.
                for(Pair num : adj.get(curr.node)){
                    // take neighbour and price
                    int neighbour = num.first;
                    int price = num.sec;
                    // if price and cost is less than previous distance and stops
                    // are less than k then update the distance in array and
                    // add the neighbour with its cost and stops + 1 in queue
                    if(cost + price < dist[neighbour] && stops <= k){
                        dist[neighbour] = cost + price;
                        que.add(new Tuple(neighbour , cost + price , stops+1));
                    }
                }
            }
            // if there is no any cheapest way within k stops then return -1
            if(dist[dst] == Integer.MAX_VALUE){
                return -1;
            }
            return dist[dst];
        }
        public class Tuple{
            // node , price , stop
            int node;
            int wt;
            int st;
            public Tuple(int node , int wt , int st){
                this.node = node;
                this.wt = wt;
                this.st = st;
            }
        }
        class Pair{
            int first;
            int sec;
            public Pair(int first , int sec){
                this.first = first;
                this.sec = sec;
            }
        }
    }
}
