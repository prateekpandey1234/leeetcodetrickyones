package DyanamicProgramming.medium;

public class InfiniteWrapAroundString {
    class Solution {
        //as we need to find the solution of unique appreances of substrings
        //hence we can not use return dp[i] like statement
        //it's much optimal to use bottom-up approach here
        public int findSubstringInWraproundString(String p) {
            //we are using a array which will tell us about the longest substring starting
            //with that char in array
            int[] count=new int[26];
            int max=0;
            for (int i=0;i<p.length();i++){
                //checking each char by char , a type of sliding window technique
                if (i>0 && (p.charAt(i)-p.charAt(i-1)==1 || p.charAt(i-1)-p.charAt(i)==25)) max++;
                    //resets the count to single char
                else max=1;
                int ind=p.charAt(i)-'a';
                //checking if there is another large substring then current one
                count[ind]=Math.max(count[ind],max);
            }
            int sum=0;
            //adding all the types of substrigns we got
            for (int i=0;i<26;i++){
                sum+=count[i];
            }
            return sum;
        }


    }

}
