package Search;
import java.util.*;
import java.io.*;
public class Round890C {
     class Codeforces {
        static int n, k;
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int t = Integer.parseInt(br.readLine());
            while (t --> 0) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                k = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                long [] a = new long[n];
                for (int i = 0; i < n; i++) a[i] = Integer.parseInt(st.nextToken());

                long max = 0;
                for (long i: a) max = Math.max(i, max);

                long low = max, high = (long) 1e18;
                while (low < high) {
                    long mid = (low + high + 1) / 2;
                    boolean ok = false;
                    for (int i = 0; i < n; i++) ok |= works(a, i, mid);
                    if (ok) low = mid;
                    else high = mid - 1;
                } System.out.println(low);
            }

            br.close();
        }

        public static boolean works(long [] a, int j, long curr_max) {
            long ops = 0;//required value to make each value as curr_max
            for (int i = j; i < n; i++) {
                if (a[i] >=curr_max - (i - j)) { 
                    return ops <= k;//we found a value such that it is greater than our curr_max-(i-j) meaning
                                    //this is the place from where we start our operation
                    //we are checking by going right so that we can face our max that will allow our operations
                } ops += (curr_max - (i - j)) - a[i];
            } return false;//max found so that we can start our opertion
        }
    }
}
