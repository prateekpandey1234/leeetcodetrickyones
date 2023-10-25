package BitManipulation.hard;
import static java.lang.Math.*;
import java.util.*;
import java.io.*;
public class Round899Div2B {


    class lmao2
    {
        static ArrayDeque<Integer>[] edges;
        static int[] arr;
        public static void main(String[] followthekkathyoninsta) throws Exception
        {
            BufferedReader infile = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(infile.readLine());
            int T = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            while(T-->0)
            {
                int N = Integer.parseInt(infile.readLine());
                long[] sets = new long[N];
                long allUnion = 0L;
                for(int t=0; t < N; t++)
                {
                    st = new StringTokenizer(infile.readLine());
                    int K = Integer.parseInt(st.nextToken());
                    for(int i=0; i < K; i++)
                        sets[t] |= 1L<<Integer.parseInt(st.nextToken());
                    allUnion |= sets[t];
                }
                int res = 0;
                for(int b=0; b <= 50; b++)
                    if((allUnion&(1L<<b)) > 0)//Checking if the number exists in our whole set
                    {
                        long temp = 0L;
                        for(long x: sets)//we are setting bits of those sets together which have a common number
                            // by in their set by checking below boolean condition
                            //using this we can union different possible sets in one go
                            if((x&(1L<<b)) == 0)
                                temp |= x;
                        res = max(res, Long.bitCount(temp));
                    }
                sb.append(res+"\n");
            }
            System.out.print(sb);
        }
        public static int[] readArr(int N, BufferedReader infile, StringTokenizer st) throws Exception
        {
            int[] arr = new int[N];
            st = new StringTokenizer(infile.readLine());
            for(int i=0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            return arr;
        }
    }
}
