




import java.io.IOException;

import java.lang.reflect.Array;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Practice {
    static int[] f = new int[46];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        f[0] = f[1] = 1;
        for (int i = 2; i < 46; i++) {
            f[i] = f[i-1]+f[i-2];
        }

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken()) ,x=Integer.parseInt(st.nextToken()),y=Integer.parseInt(st.nextToken());

            if(dfs(n,x,y)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");;
            }

        }


    }
    static boolean dfs(int n, int x, int y) {
        if (n <= 1) {
            return true;
        }
        //this means that col would be already covered by our another Fn-1
        if (f[n-1] < y && y <= f[n] ) {
            return false;
        }
        //We will cut the rectangles in the order Fn,Fn−1,…,F0
        //  Denote the coordinates of the colored cell at the step n as ⟨xn,yn⟩
        //If Fn−1<yn≤Fn and n>1 then there is no partition, since the square Fn at any location overlaps the colored cell.
        //Cut off the square Fn from the right or left edge, depending on the location of the colored cell, that is, ⟨xn−1,yn−1⟩=⟨yn,xn⟩
        // or ⟨xn−1,yn−1⟩=⟨yn−Fn,xn⟩

        if (f[n-1] >= y) {
            // WE WILL SWAP THE COORDINATES as they get rotated after each addition of new Fn value in our chart
            return dfs(n-1, y, x);
        } else {//if y is  greater than our current col
            // than we will reduce it and check it in lower one
            return dfs(n-1, f[n+1]-y+1, x);
        }
        //ex:- for n==4 , y=1,3,6,8
        //     for n==3 , y=1,2,4,5
        /// if y==7 for n==4 m then we will go check it in n==3 with y = f(4+1)-7+1,y=2
    }




}








