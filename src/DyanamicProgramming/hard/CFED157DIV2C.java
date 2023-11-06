package DyanamicProgramming.hard;

import java.io.*;
import java.util.StringTokenizer;

public class CFED157DIV2C {


 class Practice {


        //There is an obvious O(n2)
// approach: iterate over the first part, the second part and check the sum. In order to improve it, let's try to get rid of the second iteration.
//
//Consider the case where the first part is longer or equal than the second part. So, we still iterate over the first part in O(n)
//. However, instead of iterating over the exact second part, let's just iterate over its length. Now, we know the total length of the parts, but not their sums of digits. Hmm, not exactly. By fixing the longer part, we actually know what the required sum of each half should be. It's fully inside the first part. However, this first part also contains some digits that belong to the second half. So, if the sum of the second part was s
//, the total sum of the second half would be these digits plus s
//.
//
//Let l
// be the total length of the ticket: the length of the fixed first part plus the fixed length of the second part. Let suml
// be the sum of the first l2
// digits of the first part, and sumr
// be the sum of its remaining digits. Then suml=sumr+s
//. Rewrite into suml−sumr=s
//. Thus, we just know what should be the sum of the second half. And every ticket part that is exactly of the fixed length and has sum exactly suml−sumr
// will form a lucky ticket with the fixed part.
//
//So, we have to precalculate cnt[l][s]
//, which is the number of ticket parts that have length l
// and sum s
//, and use that structure to speed up the solution.
//
//The mirror case, where the second part is strictly longer than the first part, can be handled similarly.
//
//Overall complexity: O(n)
//.
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++) arr[i] = st.nextToken();
            int[][] counts = new int[46][11];//sum then length
            for(int i=0; i<n; i++){
                int sum = 0;
                //pre calculate how many strings have count[sum][length]
                for(char c: arr[i].toCharArray()) sum += c - '0';
                counts[sum][arr[i].length()] ++;
            }
            long ans = 0;
            //check for each of string from starting half  and finishing half
            for(int i=0; i<n; i++){
                int tol = 0;
                for(char c: arr[i].toCharArray()) tol += c - '0';
                int sum = 0;
                int len = 0;
                for(char c: arr[i].toCharArray()){
                    //checking if there is a string from  pre-calculation that has sum of sum-(tot-sum) and length of 2*len-arr[i].length
                    sum += c - '0';
                    len++;
                    //adding this boolean condition such that do operations  only for half from start of string
                    if(2*len>arr[i].length() && sum > tol-sum){
                        ans += counts[sum - (tol-sum)][2*len-arr[i].length()];
                    }
                }
                sum = 0;
                len = 0;
                for(int j = arr[i].length()-1; j>0; j--){
                    // doing same above process but doing with last  half of current string
                    sum += arr[i].charAt(j) - '0';
                    len++;
                    //adding this boolean condition such that do operations  only for half from back  of string
                    if(2*len>arr[i].length() && sum > tol-sum){
                        ans += counts[sum - (tol-sum)][2*len-arr[i].length()];
                    }
                }
            }
            out.write(ans + "\n");
            out.flush();






        }


    }









}
