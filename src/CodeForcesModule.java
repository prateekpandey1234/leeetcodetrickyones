import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;

import static java.lang.System.out;

public class CodeForcesModule {
    static  int[] dp;
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = s.nextInt(),k=s.nextInt(),d=s.nextInt();
        dp=new int[n+1];
        int[] arr= new int[k+1];
        for(int i=1;i<k+1;i++){
            if(i<=n){
                helper(arr,d,k,i,n-i);
            }
        }
        out.println(d);
        out.println(k);
        out.println(n);
        out.println(Arrays.toString(dp));
        out.flush();
    }
    public static int helper(int[] arr ,int d,int k,int i, int curr){
        if(curr==0)return (arr[d]!=0)?1:0;
        if(dp[curr]!=0)return dp[curr];
        arr[i]=1;
        int w=0;
        System.out.println(Arrays.toString(arr));
        for(int j=1;j<k+1;j++){
            if(j<=curr){
                arr[j]=1;
                w+=helper(arr,d,k,i,curr-j);
                arr[j]=0;
            }
        }
        return dp[curr]=w;
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        String nextLine() throws IOException {
            String str = "";
            if (st != null && st.hasMoreTokens()) {
                str = st.nextToken("\n");
            } else {
                str = br.readLine();
            }
            return str;
        }

        int[] nextArrayInt(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextArrayLong(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        double[] nextArrayDouble(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextDouble();
            }
            return arr;
        }

        String[] nextArrayString(int n) throws IOException {
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = next();
            }
            return arr;
        }

        char[] nextArrayChar() throws IOException {
            return next().toCharArray();
        }
    }
}