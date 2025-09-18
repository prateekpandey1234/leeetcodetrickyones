package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Round892D {
    class Practice {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            while(t-->0){
                int n  = Integer.parseInt(br.readLine());
                int[][] arr = new int[n][2];
                for(int i=0;i<n;i++){
                    //will only need starting and ending segment
                    st = new StringTokenizer(br.readLine());
                    arr[i][0]=Integer.parseInt(st.nextToken());
                    st.nextToken();
                    st.nextToken();
                    arr[i][1]=Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arr,((a, b)-> (a[0] -b[0])));
                int q = Integer.parseInt(br.readLine());
                List<int[]> gaps = new ArrayList<>();
                //updating our intervals into much bigger range
                gaps.add(new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE});
                for(int i=0;i<n;i++){
                    int m = gaps.size();
                    if(gaps.get(m-1)[1]<arr[i][0]){
                        gaps.add(new int[] {arr[i][0], arr[i][1]});
                    }
                    else{
                        gaps.get(m-1)[1]=Math.max(gaps.get(m-1)[1],arr[i][1]);
                    }
                }
                st = new StringTokenizer(br.readLine());
                while(q-->0){
                    int f = Integer.parseInt(st.nextToken());
                    int l=0,r= gaps.size()-1;
                    while(l<=r){
                        int mid = l+(r-l)/2;
                        if(gaps.get(mid)[0]>f){
                            r=mid-1;
                        }
                        else{
                            l=mid+1;
                        }
                    }

                    System.out.print(Math.max(f, gaps.get(r)[1]) +" ");
                }
                System.out.println();
            }

        }

    }

}
