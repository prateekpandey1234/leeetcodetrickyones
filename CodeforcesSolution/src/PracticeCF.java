



import java.io.IOException;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PracticeCF {
//Simple greedy observation: if at some point in time there exists an animal i
// such that no one fears it (there is no index aj=i
//), then it is optimal to sell that animal first.
//
//Let's iteratively sell such animals as long as they exist. After selling animal i
//, we must additionally check if animal ai
// has become such that no one fears it, and if so, add it to the list for sale.
//
//What will we get when we sell all such animals? Note that when there are no such animals left, ai
// will form a permutation, as each animal must be feared by at least one other animal.
//
//As it is known, a permutation consists of cycles of the form i→ai→aai→…→i
//.
//
//Obviously, for each cycle we must solve the problem independently, and then combine the answers in any order. Note that if we sell animals in the order of the cycle, we will only receive a single payment for the last animal sold.
//
//At the same time, it is not possible to obtain double payment for all animals in any case: the last animal sold from the cycle will always be sold for a single payment.
//
//Therefore, it is optimal to sell all animals in the order of the cycle so that the animal with the minimum cost ends up being the last in this order.
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] c = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt() ;
            }

            for (int i = 0; i < n; i++) {
                c[i] = sc.nextInt();
            }

            int[] sons = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] -= 1;
                sons[a[i]] += 1;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (sons[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> ans = new ArrayList<>();
            int[] added = new int[n];
//using toposort , and we are selling those animal first which have indegree of 0
            while (!q.isEmpty()) {
                int v = q.poll();
                ans.add(v);
                added[v] = 1;
                sons[a[v]] -= 1;

                if (sons[a[v]] == 0) {
                    q.add(a[v]);
                }
            }
//if there is a cycle then we have to change our answer depending on minimum value in our c

            for (int v = 0; v < n; v++) {
                if (added[v] == 0) {
                    int v2 = a[v];
                    List<Integer> cycle = new ArrayList<>();
                    cycle.add(v);
//detecting the cycle
                    while (v2 != v) {
                        cycle.add(v2);
                        v2 = a[v2];
                    }

                    int minc = (int) 1e9;
//finding our minimum value
                    for (int u : cycle) {
                        added[u] = 1;
                        minc = Math.min(minc, c[u]);
                    }
//adding our cycle into answer
                    for (int i = 0; i < cycle.size(); i++) {
                        if (c[cycle.get(i)] == minc) {
                            ans.addAll(cycle.subList(i + 1, cycle.size()));
                            ans.addAll(cycle.subList(0, i + 1));
                            break;
                        }
                    }
                }
            }
            for (int i = 0; i < ans.size(); i++) {
                ans.set(i, ans.get(i) + 1);
            }

            for(int i:ans)System.out.print(i+" ");
            System.out.println();
        }
    }


}


















