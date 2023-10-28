package VitrualAndLive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Round904All {




     class PracticeCF {

        //    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        StringTokenizer st;
//        while (t-- > 0) {
//            st = new StringTokenizer(br.readLine());
//            long  l = Long.parseLong(st.nextToken()),k = Integer.parseInt(st.nextToken()); long  r = k;
//            int j= (int) Math.log10(l);
//            for(int i=0;i<=j;i++)r+=(r*10L+k);
//            for(;l<=r; l++){
//                if(f(l,k)){
//                    break;
//                }
//            }
//            System.out.println(l);
//        }
//    }
//    public static boolean f(long  mid , long k){
//        long a = 0;
//        while(mid>0){
//            int j = (int) (mid/10);
//            a+=(mid-(j)* 10L);
//            mid=mid/10;
//        }
//        return a%k==0;
//    }
//public static void main(String[] args) throws IOException {
//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    int t = Integer.parseInt(br.readLine());
//    StringTokenizer st;
//    while (t-- > 0) {
//
//        int n = Integer.parseInt(br.readLine());
//        String s = br.readLine();
//        long[] ans = new long[n];
//        String sw = new StringBuilder(s).reverse().toString();
//        List<Integer>[] idxes = new ArrayList[2];
//        idxes[0] = new ArrayList<>();
//        idxes[1] = new ArrayList<>();
//        //adding indexes of 0 and 1 from behind
//        for (int i = 0; i < n; i++) {
//            idxes[sw.charAt(i) - '0'].add(i);
//        }
//
//
//        Arrays.fill(ans, -1);
//        int m = idxes[0].size();
//        for (int i = 0; i < m; i++) {
//            // to be divisible by 2^(i+1), we need have at least (i+1) 0s in front
//            ans[i] = (i == 0 ? 0 : ans[i-1]) + idxes[0].get(i) - i;//this here represents the next index of 1 we need to replace such that we get 0 in back
//        }
//        for(long i:ans)System.out.print(i+" ");
//        System.out.println();
//    }
//}
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st;
            //We can then consider the segments that do not contain position 1
            // (similarly, we can do the same for m
            //) and find the position that is covered by the largest number of such segments. This can be done using a line sweep algorithm. A segment (l,r)
            // corresponds to two events: (l,0)- the segment opens, and (r,1) - the segment closes.
            // We sort these events and iterate through them, keeping track of the number of open segments at each moment.
            // The maximum value among these quantities is what we need. The solution works in O(nlogn)
            // time.
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());int  m = (int) Long.parseLong(st.nextToken());
                List<Pair> a1 = new ArrayList<>();
                List<Pair> a2 = new ArrayList<>();
                // what we are trying is to make min=0 such that our max becomes  the highest
                // hence we are assuming that we will get min at 0 and max at m
                //we can also see that when a subset of 0, m is selected then our max-min will remain same or 0 as each number is selected
                for(int i=0;i<n;i++){
                    st = new StringTokenizer(br.readLine());
                    long l = Long.parseLong(st.nextToken())-1;
                    long r = Long.parseLong(st.nextToken());
                    if(l!=0){
                        a1.add(new Pair(l,1));
                        a1.add(new Pair(r,-1));
                    }
                    if(r!=m){
                        a2.add(new Pair(l,1));
                        a2.add(new Pair(r,-1));
                    }
                }
                Collections.sort(a1 );
                Collections.sort(a2 );
                long max=0;
                long sum=0;
                long last =-1;
                //here what we are doing is that we are sorting the indexes based on numerical value
                //after sorting we get that as we go through the list we can check where comes or not
                //ex:- m=[1,2],[3,4],[2,5],[3,6]
                //here we can see that after sorting
                // list = {[1,1],[2,-1],[2,1],[3,1],[3,-1],[4,-1],[5,-1],[6,-1]}
                //here as we went through list we can easily check where our maximum will , it will occur at position where most of the subsets intersect
                // 1 and -1 are used to tell whether our subset opens (1) or closes (-1) so that we can tell any two subsets are intersecting
                // when  1 comes after another 1 in our sorted list, and we can easily increment our answer
                // from this we can see that
                //finding our answer assuming minimum value is at 1 index
                for(Pair r:a1){
                    if(r.i!=last){
                        max=Math.max(max,sum);//as we encounter -1 after 1 we see that one of subsets is closed hence we calculate max   at this point
                        //because after this our values will not be incremented
                    }
                    sum+=r.j;//we would simply add 1 or -1 to decrease or increase our sum
                    last=r.i;
                }
                //same above process will be done assuming our minimum value is at m position
                sum=0;
                last=-1;
                for(Pair r:a2){
                    if(r.i!=last){
                        max=Math.max(max,sum);
                    }
                    sum+=r.j;
                    last=r.i;
                }
                System.out.println(max);
            }
        }
        static class Pair implements Comparable<Pair> {
            long i, j;
            public Pair(long x, long y) {
                this.i = x;
                this.j = y;
            }

            public int compareTo(Pair o) {

                int x = Long.compare(i, o.i);

                if (x == 0) {
                    x = Long.compare(j, o.j);
                }

                return x;

            }
        }


    }

















}
