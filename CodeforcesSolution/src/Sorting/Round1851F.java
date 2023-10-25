package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Round1851F {


     class Practice {
        static class Pair {
            int value;
            int index;

            public Pair(int v, int id) {
                value = v;
                index = id;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            while (t-- > 0) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
                Pair[] arr = new Pair[n];
                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < n; i++) {
                    arr[i] = new Pair(Integer.parseInt(st.nextToken()), i + 1);
                }
                Arrays.sort(arr, (a, b) -> Integer.compare(a.value, b.value));

                int l, r, ans, X;
                l = r = ans = X = -1;

                for (int i = 1; i < n; ++i) {
                    int a = arr[i - 1].value, b = arr[i].value;
                    int temp = 0, x = 0;
                    //checking every bit
                    for (int j = 0; j < k; ++j) {
                        if (((a >> j) & 1) == ((b >> j) & 1)) {//if they have bits same  at the same place we
                            // would have high chance of getting larger value
                            temp |= (1 << j);//setting that bit in our answer
                            if (((a >> j) & 1) == 0)
                                x |= (1 << j);
                        }
                    }

                    if (temp > ans) {
                        ans = temp;
                        X = x;
                        l = arr[i - 1].index;
                        r = arr[i].index;
                    }

                }
                System.out.println(l + " " + r + " " + X);

            }

        }
    }





}
