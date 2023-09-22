import java.util.*;
import java.io.*;

 class Codeforces {
    static int n;
    static int [] getSubTreeSize;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] p = new int[n + 1];
        for (int i = 2; i <= n; i++) p[i] = Integer.parseInt(st.nextToken());
        graph = new ArrayList<> ();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<> ());
        for (int i = 2; i <= n; i++) graph.get(p[i]).add(i);

        getSubTreeSize = new int[n + 1];
        dfs1(1); // Find subtree sizes
        dfs2(1); // Find answer
        System.out.println(res);

        br.close();
    }

    public static int dfs1(int node) {
        int size = 1;
        for (int i: graph.get(node)) {
            size += dfs1(i);
        } return getSubTreeSize[node] = size;
    }

    static int res = 0;
    public static void dfs2(int node) {
        ArrayList<Integer> childrenSizes = new ArrayList<> ();
        for (int i: graph.get(node)) childrenSizes.add(getSubTreeSize[i]);
        int sum = 0;
        for (int i: childrenSizes) sum += i;
        // DP
        boolean [] dp = new boolean[sum + 1]; dp[0] = true;
        for (int i: childrenSizes) {
            //here sum also means number of nodes in subtree
            //we are making every possible sum true such that 2 subtree exists with sum j and i
            for (int j = sum; j >= i; j--) dp[j] |= dp[j - i];
        }
        int maxProd = 0;
        for (int i = 0; i <= sum / 2; i++)
            //taking only those sums whose subtree is possible here
            if (dp[i]) maxProd = Math.max(maxProd, i * (sum - i));
        res += maxProd;
        for (int i: graph.get(node)) dfs2(i);
    }
}