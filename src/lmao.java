import java.io.*;
import java.util.*;

public class lmao {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Integer> mp = new HashMap<>();
        long[] freq = new long[n];
        long[] arr = new long[n + 1];
        Arrays.fill(arr, 0L);

        for (int i = 0; i < n; i++) {
            long x = a[i];
            mp.put(x, mp.getOrDefault(x, 0) + 1);
            freq[i] = mp.get(x);
        }

        SegTree seg = new SegTree(n + 1);
        Map<Long, Integer> mp2 = new HashMap<>();
        long ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            mp2.put(a[i], mp2.getOrDefault(a[i], 0) + 1);
            long x = freq[i];
            if (x > 1) {
                ans += seg.getSum(1, (int)x - 1);
            }
            seg.add(mp2.get(a[i]), 1L);
        }

        System.out.println(ans);
    }
}

class  SegTree {
    long[] tree;
    int n;

    public  SegTree(int size) {
        this.n = size;
        // 4*n is the safe upper bound size for the array
        tree = new long[4 * n];
    }

    // Wrapper function to make calling easier
    public void add(int idx, long val) {
        update(1, 0, n - 1, idx, val);
    }

    // Wrapper function to make calling easier
    public long getSum(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }

    // The recursive update function
    private void update(int node, int start, int end, int idx, long val) {
        // Base Case: Leaf Node
        if (start == end) {
            tree[node] += val; // "Apply" logic: Add value to existing
            return;
        }

        int mid = (start + end) / 2;

        // Decide whether to go Left or Right
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }

        // "Merge" logic: Parent sum = Left Child + Right Child
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }

    // The recursive query function
    private long query(int node, int start, int end, int L, int R) {
        // Case 1: Range is completely outside (No Overlap)
        if (R < start || end < L) {
            return 0; // Identity value for sum is 0
        }

        // Case 2: Range is completely inside (Total Overlap)
        if (L <= start && end <= R) {
            return tree[node];
        }

        // Case 3: Partial Overlap - Split and Sum
        int mid = (start + end) / 2;
        long leftSum = query(2 * node, start, mid, L, R);
        long rightSum = query(2 * node + 1, mid + 1, end, L, R);

        return leftSum + rightSum;
    }
}
