import java.io.*;
import java.util.*;
import java.lang.*;

public class CodeForcesModule {
    public static void main(String[] args) throws IOException {
        FastReader s = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = s.nextInt();
        long[] arr = s.nextArrayLong(n);
        long[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        for(int i = 1; i < n; i++){
            arr[i] += arr[i - 1];
            sorted[i] += sorted[i - 1];
        }
        int t = s.nextInt();
        while(t-->0){
            int type = s.nextInt(), l = s.nextInt(), r = s.nextInt();
            if(type == 1){
                if(l == 1){
                    out.println(arr[r - 1]);
                    continue;
                }
                out.println(arr[r - 1] - arr[l - 2]);
            }
            else{
                if(l == 1){
                    out.println(sorted[r - 1]);
                    continue;
                }
                out.println(sorted[r - 1] - sorted[l - 2]);
            }
        }
        out.flush();
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