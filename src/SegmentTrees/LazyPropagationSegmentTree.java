package SegmentTrees;

import java.util.*;
public class LazyPropagationSegmentTree {
    //leetcode 3569
    class Solution {
        // Maximum Lazy Update Segment Tree
        static class SegmentTree {
            int n;
            int[] nodes;
            int[] lazy;

            // 0-indexed: children at 2*cur+1 and 2*cur+2
            private void build(int cur, int left, int right, int[] init) {
                if (left == right) { // base case
                    nodes[cur] = init[left];
                    return;
                }
                int mid = (left + right) / 2;
                build(2 * cur + 1, left, mid, init);
                build(2 * cur + 2, mid + 1, right, init);
                nodes[cur] = Math.max(nodes[2 * cur + 1], nodes[2 * cur + 2]);
            }

            private void push(int cur, int left, int right) {
                if (lazy[cur] != 0) { // need update
                    nodes[cur] += lazy[cur];
                    if (left != right) { // propagate to children
                        lazy[2 * cur + 1] += lazy[cur];
                        lazy[2 * cur + 2] += lazy[cur];
                    }
                    lazy[cur] = 0;
                }
            }

            private void update(int cur, int qL, int qR, int val, int l, int r) {
                push(cur, l, r);
                if (r < qL || qR < l) return; // out of range
                if (qL <= l && r <= qR) { // completely inside range
                    lazy[cur] += val;
                    push(cur, l, r);
                    return;
                }
                int mid = (l + r) / 2;
                update(2 * cur + 1, qL, qR, val, l, mid);
                update(2 * cur + 2, qL, qR, val, mid + 1, r);
                nodes[cur] = Math.max(nodes[2 * cur + 1], nodes[2 * cur + 2]);
            }

            public SegmentTree(int n, int[] init) {
                this.n = n;
                nodes = new int[4 * n];
                lazy = new int[4 * n];
                build(0, 0, n - 1, init);
            }

            public int query() { // special case: only need the max in range 0~n-1
                push(0, 0, n - 1);
                return nodes[0];
            }

            public void update(int qL, int qR, int val) {
                if (qL > qR) return; // Safety check
                update(0, qL, qR, val, 0, n - 1);
            }
        }

        static final int MAX_NUM = 100000;

        public int[] maximumCount(int[] nums, int[][] queries) {
            // 1. Calculate all primes from 1 - 1E5 with sieve
            boolean[] prime = new boolean[MAX_NUM + 1];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;
            for (int i = 2; i * i <= MAX_NUM; ++i) {
                if (prime[i]) {
                    for (int val = i * i; val <= MAX_NUM; val += i) {
                        prime[val] = false;
                    }
                }
            }

            // 2. Precomputing initial state and construct HashMap
            int n = nums.length;
            Map<Integer, TreeSet<Integer>> primeToInd = new HashMap<>();

            for (int i = 0; i < n; ++i) {
                if (prime[nums[i]]) {
                    primeToInd.computeIfAbsent(nums[i], k -> new TreeSet<>()).add(i);
                }
            }

            int[] delta = new int[n + 1];
            for (TreeSet<Integer> indMap : primeToInd.values()) {
                if (indMap.size() >= 2) {
                    delta[indMap.first() + 1] += 1;
                    delta[indMap.last() + 1] -= 1;
                }
            }

            for (int i = 1; i <= n; ++i) {
                delta[i] += delta[i - 1];
            }

            // 3. Solve each query
            SegmentTree seg = new SegmentTree(n, delta);
            int[] ans = new int[queries.length]; // Changed from List to array

            for (int k = 0; k < queries.length; k++) { // Use index k for ans array
                int ind = queries[k][0];
                int newVal = queries[k][1];
                int oldVal = nums[ind];
                nums[ind] = newVal;

                // --- Remove the oldVal ---
                if (prime[oldVal]) {
                    TreeSet<Integer> indSet = primeToInd.get(oldVal);
                    if (indSet != null) {
                        if (indSet.size() >= 2) {
                            int left = indSet.first() + 1;
                            int right = indSet.last();

                            if (ind == left - 1 || ind == right) {
                                seg.update(left, right, -1);//lazy propagting the tree with -1 in that tree
                                indSet.remove(ind);

                                if (indSet.size() >= 2) {
                                    left = indSet.first() + 1;
                                    right = indSet.last();
                                    seg.update(left, right, 1);
                                }
                            } else {
                                indSet.remove(ind);
                            }
                        } else {
                            indSet.remove(ind);
                        }
                        if (indSet.isEmpty()) {
                            primeToInd.remove(oldVal);//remove the key
                        }
                    }
                }

                // --- Add the newVal ---
                if (prime[newVal]) {
                    primeToInd.putIfAbsent(newVal, new TreeSet<>());
                    TreeSet<Integer> indSet = primeToInd.get(newVal);

                    if (!indSet.isEmpty()) {
                        int left = indSet.first() + 1;
                        int right = indSet.last();

                        if (ind < left - 1 || ind > right) {
                            if (indSet.size() >= 2) {
                                seg.update(left, right, -1);
                            }
                            indSet.add(ind);

                            left = indSet.first() + 1;
                            right = indSet.last();
                            seg.update(left, right, 1);
                        } else {
                            indSet.add(ind);
                        }
                    } else {
                        indSet.add(ind);
                    }
                }

                ans[k] = primeToInd.size() + seg.query(); // Store result in array
            }
            return ans;
        }
    }
}
